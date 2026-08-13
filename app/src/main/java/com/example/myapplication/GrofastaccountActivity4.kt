package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class GrofastaccountActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastaccount4)

        val shop = findViewById<LinearLayout>(R.id.account_shop)
        shop.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.account_explore)
        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val cart = findViewById<LinearLayout>(R.id.account_cart)
        cart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.account_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
            finish()
        }
    }
}