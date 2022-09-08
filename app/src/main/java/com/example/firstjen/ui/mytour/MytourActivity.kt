package com.example.firstjen.ui.mytour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.firstjen.navigation.JenApp

class MytourActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MytourApp()
        }
    }
}

@Composable
fun MytourApp() {
    JenApp(MytourTheme())
}
