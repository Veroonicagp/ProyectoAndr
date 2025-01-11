package com.example.readytoenjoy.core.data.activity

import kotlinx.coroutines.flow.StateFlow

interface ActivityRepositoryInterface {

    suspend fun getActivities(): List<Activity>
    suspend fun getOne(id:String): Activity

    val setStream: StateFlow<List<Activity>>
}