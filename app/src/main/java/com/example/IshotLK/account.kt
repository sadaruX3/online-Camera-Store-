package com.example.IshotLK

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.IshotLK.fragments.FavouritesFragment
import com.example.IshotLK.fragments.HomeFragment
import com.example.IshotLK.fragments.ProfileFragment
import com.example.IshotLK.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView




class account : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account) //  Move this to the top

        findViewById<Button>(R.id.btnlogout).setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        val homeFragment = HomeFragment()
        val favouritesFragment = FavouritesFragment()
        val settingsFragment = SettingsFragment()
        val profileFragment = ProfileFragment()



        makeCurrentFragment(profileFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation2)

        bottomNavigationView.selectedItemId = R.id.profileBtn

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBtn -> {
                    startActivity(Intent(this, home::class.java))
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


                R.id.profileBtn -> true
                else -> false
            }

        }




    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}