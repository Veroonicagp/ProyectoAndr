package com.example.readytoenjoy.core.network

import com.example.readytoenjoy.core.network.activity.ActivityListRawResponse
import com.example.readytoenjoy.core.network.activity.ActivityRawResponse
import com.example.readytoenjoy.core.network.adevn.AdvenListRawResponse
import com.example.readytoenjoy.core.network.adevn.AdvenRawResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReadyToEnjoyApiService {
    @GET("activities")
    suspend fun getAllActivitiesFromSercice(): Response<ActivityListRawResponse>

    @GET("activities/{id}")
    suspend fun readOneFomService(@Path("id") id: String): Response<ActivityRawResponse>

    @GET("adventurers")
    suspend fun getAllAdvensFromSercice(): Response<AdvenListRawResponse>

    @GET("adventurers/id")
    suspend fun readOneFromService(@Path("id") id: String): Response<AdvenRawResponse>

    //registro
    //@POST("auth/local/register")
    //suspend fun register():

    //login
    //@POST("auth/local")
    //suspend fun login():


}