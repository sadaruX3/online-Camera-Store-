package com.example.IshotLK

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.IshotLK.fragments.FavouritesFragment
import com.example.IshotLK.fragments.HomeFragment
import com.example.IshotLK.fragments.ProfileFragment
import com.example.IshotLK.fragments.SettingsFragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val favouritesFragment = FavouritesFragment()
        val settingsFragment = SettingsFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBtn -> makeCurrentFragment(homeFragment)
                R.id.buyBtn -> makeCurrentFragment(favouritesFragment)
                R.id.rentBtn -> makeCurrentFragment(settingsFragment)
                R.id.profileBtn -> makeCurrentFragment(profileFragment)
            }
            true
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBtn -> {
                    startActivity(Intent(this, com.example.IshotLK.home::class.java))
                    true
                }

                R.id.buyBtn -> {
                    startActivity(Intent(this, buypage::class.java))
                    true
                }

                R.id.rentBtn -> {
                    startActivity(Intent(this, rentpage::class.java))
                    true
                }

                R.id.profileBtn -> {
                    startActivity(Intent(this, account::class.java))
                    true
                }

                R.id.homeBtn -> true
                else -> false
            }
        }


        val imageView: ImageView = findViewById(R.id.imgcart)

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

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }


}