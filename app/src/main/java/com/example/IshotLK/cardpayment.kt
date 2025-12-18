package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cardpayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cardpayment)

        val backButton: ImageView = findViewById(R.id.backbtn)
        val payButton: Button = findViewById(R.id.btnpay)
        val cardNumberEditText: EditText = findViewById(R.id.edtcardnumber)
        val mmYyEditText: EditText = findViewById(R.id.edtmmyy)
        val cvvEditText: EditText = findViewById(R.id.edtcvv)
        val visaRadioButton: RadioButton = findViewById(R.id.visabtn)
        val masterRadioButton: RadioButton = findViewById(R.id.masterbtn)

        backButton.setOnClickListener {
            val intent = Intent(this, paymentmethod::class.java)
            startActivity(intent)
        }

        payButton.setOnClickListener {
            val cardNumber = cardNumberEditText.text.toString().trim()
            val mmYy = mmYyEditText.text.toString().trim()
            val cvv = cvvEditText.text.toString().trim()

            // Validations
            if (cardNumber.isEmpty()) {
                showToast("Card number cannot be empty")
                return@setOnClickListener
            } else if (!cardNumber.matches(Regex("\\d{16}"))) {
                showToast("Card number must be exactly 16 digits")
                return@setOnClickListener
            }

            if (mmYy.isEmpty()) {
                showToast("Expiry date (MM/YY) cannot be empty")
                return@setOnClickListener
            } else if (!mmYy.matches(Regex("\\d{2}/\\d{2}"))) {
                showToast("Expiry date must be in MM/YY format")
                return@setOnClickListener
            }

            if (cvv.isEmpty()) {
                showToast("CVV cannot be empty")
                return@setOnClickListener
            } else if (!cvv.matches(Regex("\\d{3}"))) {
                showToast("CVV must be exactly 3 digits")
                return@setOnClickListener
            }

            if (!visaRadioButton.isChecked && !masterRadioButton.isChecked) {
                showToast("Please select either Visa or MasterCard")
                return@setOnClickListener
            }

            // If all validations pass, proceed to payment success screen
            val intent = Intent(this, paymentsuccessfull::class.java)
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}