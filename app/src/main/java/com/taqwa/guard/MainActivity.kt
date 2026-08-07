package com.taqwa.guard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taqwa.guard.ui.HomeScreen
import com.taqwa.guard.ui.theme.GuardTheme

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
