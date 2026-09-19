package com.example.myapplication.account
import com.example.myapplication.R
import com.example.myapplication.onboarding.OnboardingActivity
import com.example.myapplication.cart.CartActivity
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val shop = findViewById<LinearLayout>(R.id.account_shop)
        shop.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.account_explore)
        explore.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }

        val cart = findViewById<LinearLayout>(R.id.account_cart)
        cart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.account_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }

        val comingSoon = View.OnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        findViewById<View>(R.id.edit_profile_button).setOnClickListener(comingSoon)
        findViewById<View>(R.id.orders_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.second_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.delivery_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.payment_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.promo_code_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.notification_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.help_container).setOnClickListener(comingSoon)
        findViewById<View>(R.id.about_container).setOnClickListener(comingSoon)

        findViewById<View>(R.id.logout_btn).setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}