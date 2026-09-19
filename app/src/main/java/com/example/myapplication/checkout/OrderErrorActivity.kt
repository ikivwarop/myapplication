package com.example.myapplication.checkout
import com.example.myapplication.R
import com.example.myapplication.favorites.FavoritesAdapter
import com.example.myapplication.favorites.FavoritesManager
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_error)

        val recycler = findViewById<RecyclerView>(R.id.error_favorites_recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FavoritesAdapter(FavoritesManager.getItems()) { }

        findViewById<ImageView>(R.id.error_close_button).setOnClickListener { finish() }

        findViewById<AppCompatButton>(R.id.please_button).setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
            finish()
        }

        findViewById<AppCompatButton>(R.id.error_back_to_home_button).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
