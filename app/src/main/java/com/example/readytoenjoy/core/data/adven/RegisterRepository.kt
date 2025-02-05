package com.example.readytoenjoy.core.data.adven

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.readytoenjoy.core.network.ReadyToEnjoyApiService
import com.example.readytoenjoy.core.network.adevn.UserRequest
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.readytoenjoy.core.network.adevn.AdvenRequest
import com.example.readytoenjoy.core.network.adevn.AventureroData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val USERNAME_KEY  = stringPreferencesKey("username")
private val EMAIL_KEY  = stringPreferencesKey("email")
private val PASSWORD_KEY  = stringPreferencesKey("password")
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


@Singleton
class RegisterRepository @Inject constructor(@ApplicationContext val context: Context,
                                             private val api: ReadyToEnjoyApiService) {

    suspend fun register(username:String, email:String, password:String) {
        val userResponse = api.register(UserRequest(
            username,email,password))
        // Me he logueado
        if (userResponse.isSuccessful) {
            // TODO GUARDAR LOCALMENTE EL TOKEN
            userResponse.body()!!.jwt
            val user = userResponse.body()
            val userId = user?.user?.id

            if (userId != null) {
                println("✅ Usuario creado con ID: $userId")

                // 2️⃣ Registrar Aventurero vinculado al Usuario
                val aventureroRequest = AdvenRequest(
                    AventureroData(
                        name = username,
                        email = email,
                        password = password, // ✅ Incluido el password
                        userId = userId // Relación con el usuario creado
                    )
                )

                val aventureroResponse = api.registerAdven(aventureroRequest)

                if (aventureroResponse.isSuccessful) {
                    println("✅ Aventurero creado con éxito")
                } else {
                    println("❌ Error creando aventurero: ${aventureroResponse.errorBody()?.string()}")
                }

            } else {
                println("❌ Error: No se obtuvo el ID del usuario.")
            }
        }
        // No me he logueado
        else {
            null
        }

    }


    @SuppressLint("SuspiciousIndentation")
    suspend fun isRegistered(): Boolean {
        val localEmail = context.dataStore.data.map {
            it[EMAIL_KEY] ?: ""
        }.first()


        return if (localEmail.isBlank()) {
            false
        }
        else {
            val response = api.readUser(localEmail)
            response.isSuccessful
        }

    }
}