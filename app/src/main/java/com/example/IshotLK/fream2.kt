package com.example.IshotLK

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class fream2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fream2)

        val nextButton = findViewById<Button>(R.id.button3) // make sure this id exists in XML
        nextButton.setOnClickListener {
            startActivity(Intent(this, fream3::class.java)) // use the correct class name
        }

    }
}