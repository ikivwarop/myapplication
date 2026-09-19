package com.example.myapplication.cart
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.checkout.CheckoutActivity
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var emptyLabel: TextView
    private lateinit var totalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recycler = findViewById(R.id.cart_recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        emptyLabel = findViewById(R.id.empty_label)
        totalPrice = findViewById(R.id.total_price)

        refresh()

        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.checkout_Btn).setOnClickListener {
            if (CartManager.getItems().isEmpty()) {
                Toast.makeText(this, "Your cart is empty", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, CheckoutActivity::class.java))
            }
        }

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

    override fun onResume() {
        super.onResume()
        refresh()
    }

    private fun refresh() {
        val items = CartManager.getItems()
        recycler.adapter = CartAdapter(items) { refresh() }
        emptyLabel.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
        recycler.visibility = if (items.isEmpty()) View.GONE else View.VISIBLE
        totalPrice.text = "₦${CartManager.totalPrice()}"
    }
}
