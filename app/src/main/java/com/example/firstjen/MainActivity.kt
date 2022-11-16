package com.example.firstjen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.firstjen.ui.mytour.MytourActivity
import com.example.firstjen.ui.partner.PartnerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, CommonActivity::class.java))
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this, MytourActivity::class.java))
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            startActivity(Intent(this, PartnerActivity::class.java))
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            startActivity(Intent(this, PartnerActivity::class.java))
        }
    }
}

