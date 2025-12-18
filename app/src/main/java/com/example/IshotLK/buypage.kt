package com.example.IshotLK

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class buypage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buypage)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.buyBtn

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.homeBtn ->{
                    startActivity(Intent(this,home::class.java))
                    true
                }

                R.id.buyBtn ->{
                    startActivity(Intent(this,buypage::class.java))
                    true
                }

                R.id.rentBtn ->{
                    startActivity(Intent(this,rentpage::class.java))
                    true
                }

                R.id.profileBtn ->{
                    startActivity(Intent(this,account::class.java))
                    true
                }

                R.id.buyBtn -> true
                else -> false
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

}
