package com.example.myapplication

import android.content.Intent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    protected fun setupBottomNavigation() {

        val shop = findViewById<LinearLayout>(R.id.shop_layout)
        val explore = findViewById<LinearLayout>(R.id.explore)
        val mycart = findViewById<LinearLayout>(R.id.my_cart_label)
        val favorite = findViewById<LinearLayout>(R.id.favorite)
        val account = findViewById<LinearLayout>(R.id.account)

        shop.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
            finish()
        }

        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
            finish()
        }

        mycart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
            finish()
        }

        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
            finish()
        }

        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
            finish()
        }
    }
}