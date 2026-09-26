package com.example.smartlifeacademy.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val id: String,
    val title: String,
    val description: String,
    val instructor: String,
    val progress: Float = 0f // 0.0 to 1.0
)
