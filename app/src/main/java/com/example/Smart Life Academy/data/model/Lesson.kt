package com.example.smartlifeacademy.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Lesson(
    val id: String,
    val courseId: String,
    val title: String,
    val videoUrl: String? = null,
    val content: String = "",
    val isCompleted: Boolean = false
)
