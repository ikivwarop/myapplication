package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class GrofastmycartActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastmycart4)

        val shop = findViewById<LinearLayout>(R.id.my_cart_shop)
        shop.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.my_cart_explore)
        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val favorite = findViewById<LinearLayout>(R.id.my_cart_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.my_cart_account)
        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
            finish()
        }
    }
}