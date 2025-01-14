package com.example.readytoenjoy.core.network.adevn

import com.example.readytoenjoy.core.network.activity.ActivityResponse

data class AdvenListRawResponse(
    val data: List<AdvenResponse>
)

data class AdvenRawResponse(
    val data: AdvenResponse
)