package com.example.myapplication.checkout
import com.example.myapplication.R
import com.example.myapplication.cart.CartAdapter
import com.example.myapplication.cart.CartManager
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val recycler = findViewById<RecyclerView>(R.id.checkout_cart_recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CartAdapter(CartManager.getItems()) { recycler.adapter?.notifyDataSetChanged() }

        findViewById<TextView>(R.id.checkout_total_price).text = "₦${CartManager.totalPrice()}"

        findViewById<ImageView>(R.id.checkout_close_button).setOnClickListener { finish() }

        findViewById<Button>(R.id.place_order_button).setOnClickListener {
            CartManager.clear()
            startActivity(Intent(this, OrderAcceptedActivity::class.java))
            finish()
        }
    }
}
