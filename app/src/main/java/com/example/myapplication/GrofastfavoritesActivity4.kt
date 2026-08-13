package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class GrofastfavoritesActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastfavorites4)

        val shop = findViewById<LinearLayout>(R.id.favorite_shop)
        shop.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.favorite_explore)
        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val cart = findViewById<LinearLayout>(R.id.favorite_cart)
        cart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
            finish()
        }


        val account = findViewById<LinearLayout>(R.id.favorite_account)
        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
        }
    }
}