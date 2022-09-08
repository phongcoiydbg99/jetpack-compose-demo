package com.example.firstjen.ui.mytour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstjen.navigation.JenApp
import com.example.firstjen.ui.theme.MytourTheme

class MytourActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JenApp(MytourTheme())
        }
    }
}

