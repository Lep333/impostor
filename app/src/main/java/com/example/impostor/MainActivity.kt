package com.example.impostor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.impostor.ui.theme.ImpostorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImpostorTheme (darkTheme = true) {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                ) { innerPadding ->
                    App(innerPadding)
                }
            }
        }
    }
}