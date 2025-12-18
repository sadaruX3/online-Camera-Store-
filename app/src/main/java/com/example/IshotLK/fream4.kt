package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class fream4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fream4)
        val nextButton = findViewById<Button>(R.id.button3) // make sure this id exists in XML
        nextButton.setOnClickListener {
            startActivity(Intent(this, signin::class.java)) // use the correct class name
        }
    }
}