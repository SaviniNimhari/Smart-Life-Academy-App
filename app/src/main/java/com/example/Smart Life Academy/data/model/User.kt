package com.example.smartlifeacademy.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val uid: String,
    val name: String,
    val email: String,
    val role: String // "Student" or "Instructor"
)
