package com.example.myapplication.cart
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val shop = findViewById<LinearLayout>(R.id.my_cart_shop)
        shop.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.my_cart_explore)
        explore.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }

        val favorite = findViewById<LinearLayout>(R.id.my_cart_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.my_cart_account)
        account.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}