package com.example.firstjen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstjen.navigation.JenApp
import com.example.firstjen.ui.common.theme.BaseTheme
import com.example.firstjen.ui.theme.MytourTheme

class CommonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JenApp(BaseTheme())
        }
    }
}

