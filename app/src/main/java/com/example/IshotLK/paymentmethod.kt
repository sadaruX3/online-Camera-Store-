package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class paymentmethod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paymentmethod)

        val button : Button = findViewById(R.id.radiocard)

        button.setOnClickListener {
            val intent = Intent(this, cardpayment::class.java)
            startActivity(intent)
        }



        val button1 : Button = findViewById(R.id.radiocod)

        button1.setOnClickListener {
            val intent = Intent(this, paymentsuccessfull::class.java)
            startActivity(intent)
        }



        val imageView : ImageView = findViewById(R.id.backbtn)

        imageView.setOnClickListener {
            val intent = Intent(this, cart::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}