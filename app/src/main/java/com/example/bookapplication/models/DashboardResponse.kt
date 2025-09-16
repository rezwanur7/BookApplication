package com.example.bookapplication.models

data class DashboardResponse(
    val entities: List<EntityDetails>,
    val entityTotal: Int
)