package com.example.readytoenjoy.core.network.activity

import com.example.readytoenjoy.core.data.activity.Activity
import retrofit2.Response

interface ActivityNetworkRepositoryInterface {
    suspend fun read(): Response<ActivityListRawResponse>
    suspend fun readOne(id: String): Response<Activity>
}