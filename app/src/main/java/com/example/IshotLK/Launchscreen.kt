package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Launchscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchscreen) // match your XML name

        val nextButton = findViewById<Button>(R.id.button1) // make sure this id exists in XML
        nextButton.setOnClickListener {
            startActivity(Intent(this, fream2::class.java)) // use the correct class name
        }
    }
}
