package com.example.readytoenjoy.core.network.activity

data class ActivityAttributesResponse(
    val title: String,
    val location: String,
    val price: String,
    val description: String
)

data class ActivityResponse(
    val id: String,
    val attributes: ActivityAttributesResponse
    /**
    val title: String,
    val location: String,
    val price: String,
    val description: String,*/
)
