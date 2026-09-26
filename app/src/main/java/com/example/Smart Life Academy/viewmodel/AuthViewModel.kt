package com.example.smartlifeacademy.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlifeacademy.data.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()
    var authMessage = mutableStateOf("")

    fun register(
        email: String,
        password: String,
        role: String = "Student",
        onSuccess: () -> Unit
    ){
        viewModelScope.launch {
            val result = repository.signUp(email, password, role)

            if (result.isSuccess){
                authMessage.value = "Registered successfully as $role"
                delay(1500)
                onSuccess()
            } else {
                authMessage.value =
                    result.exceptionOrNull()?.message ?: "Registration failed"
            }
        }
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ){
        viewModelScope.launch {
            val result = repository.login(email, password)

            if (result.isSuccess){
                authMessage.value = "Login Successful"
                onSuccess()
            } else {
                authMessage.value =
                    result.exceptionOrNull()?.message ?: "Login failed"
            }
        }
    }
}
