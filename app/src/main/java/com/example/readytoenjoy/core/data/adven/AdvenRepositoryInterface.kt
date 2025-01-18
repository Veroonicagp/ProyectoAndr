package com.example.readytoenjoy.core.data.adven

import dagger.Provides
import kotlinx.coroutines.flow.StateFlow

interface AdvenRepositoryInterface {
    suspend fun login()
    suspend fun getAdven(): List<Adven>
    suspend fun getOneAdven(id:String): Adven
    val setStream: StateFlow<List<Adven>>
}