package com.example.myapplication.checkout
import com.example.myapplication.R
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class OrderAcceptedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_accepted)

        findViewById<MaterialButton>(R.id.track_order_button).setOnClickListener {
            Toast.makeText(this, "Order tracking isn't available yet", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialButton>(R.id.back_to_home_button).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
