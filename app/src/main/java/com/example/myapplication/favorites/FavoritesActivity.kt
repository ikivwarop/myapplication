package com.example.myapplication.favorites
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.cart.CartActivity
import com.example.myapplication.cart.CartManager
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.product.ProductDetailActivity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var emptyLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        recycler = findViewById(R.id.favorites_recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        emptyLabel = findViewById(R.id.empty_label)

        refresh()

        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.cart_Btn).setOnClickListener {
            val items = FavoritesManager.getItems()
            if (items.isEmpty()) {
                Toast.makeText(this, "No favorites to add", Toast.LENGTH_SHORT).show()
            } else {
                items.forEach { CartManager.add(it.image, it.name, it.weight, it.price) }
                Toast.makeText(this, "Added all favorites to cart", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CartActivity::class.java))
            }
        }

        val shop = findViewById<LinearLayout>(R.id.favorite_shop)
        shop.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.favorite_explore)
        explore.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }

        val cart = findViewById<LinearLayout>(R.id.favorite_cart)
        cart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val account = findViewById<LinearLayout>(R.id.favorite_account)
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
        val items = FavoritesManager.getItems()
        recycler.adapter = FavoritesAdapter(items) { item ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("image", item.image)
            intent.putExtra("name", item.name)
            intent.putExtra("weight", item.weight)
            intent.putExtra("price", item.price)
            startActivity(intent)
        }
        emptyLabel.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
        recycler.visibility = if (items.isEmpty()) View.GONE else View.VISIBLE
    }
}
