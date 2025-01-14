package com.example.readytoenjoy.core.network.activity

data class ActivityListRawResponse(
    /**val count: String,
    val prev: String?,
    val next: String?,*/
    val data: List<ActivityResponse>
)

data class ActivityRawResponse(
    val data: ActivityResponse
)
