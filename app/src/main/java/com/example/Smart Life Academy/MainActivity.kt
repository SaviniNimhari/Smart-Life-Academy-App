package com.example.smartlifeacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.smartlifeacademy.navigation.AppNavigation
import com.example.smartlifeacademy.ui.theme.SmartLifeAcademyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SmartLifeAcademyTheme {
                AppNavigation()
            }
        }
    }
}