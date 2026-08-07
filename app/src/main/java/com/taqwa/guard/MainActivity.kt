package com.taqwa.guard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taqwa.guard.ui.theme.GuardTheme
import com.taqwa.guard.ui.theme.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuardTheme {
                HomeScreen()
            }
        }
    }
}
