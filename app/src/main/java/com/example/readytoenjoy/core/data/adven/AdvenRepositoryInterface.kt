package com.example.readytoenjoy.core.data.adven

import kotlinx.coroutines.flow.StateFlow

interface AdvenRepositoryInterface {

    suspend fun login()
    suspend fun getAdven(): List<Adven>
    suspend fun getOneAdven(id:String): Adven

    val setStream: StateFlow<List<Adven>>
}