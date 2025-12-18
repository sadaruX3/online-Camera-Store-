package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        findViewById<Button>(R.id.btnsignin).setOnClickListener {
            startActivity(Intent(this, account::class.java))
        }

        findViewById<TextView>(R.id.tvsignup).setOnClickListener {
            startActivity(Intent(this, signup::class.java))
        }
    }
}
