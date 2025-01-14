package com.example.readytoenjoy.core.network.adevn

data class AdvenAttributesResponse(
    val name: String,
    val surname: String,
)

data class AdvenResponse(
    val id: String,
    val attributes: AdvenAttributesResponse
)


