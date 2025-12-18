package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen)
        lifecycleScope.launch {
            delay(6000) // 50 seconds = 50,000 ms
            val intent = Intent(this@MainActivity, Launchscreen::class.java)
            startActivity(intent)
            finish() // close MainActivity so user can't go back
        }
    }

}
