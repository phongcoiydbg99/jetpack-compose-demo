package com.example.firstjen.ui.partner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstjen.navigation.JenApp
import com.example.firstjen.ui.theme.PartnerTheme

class PartnerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JenApp(PartnerTheme())
        }
    }
}

