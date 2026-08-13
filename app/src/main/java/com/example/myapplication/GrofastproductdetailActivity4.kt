package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GrofastproductdetailActivity4 :   AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastproductdetail4)

        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val weight = intent.getStringExtra("weight")
        val price = intent.getStringExtra("price")
        val description = intent.getStringExtra("description")

        val productImage = findViewById<ImageView>(R.id.product_image)
        val productName = findViewById<TextView>(R.id.product_name)
        val productWeight = findViewById<TextView>(R.id.product_weight)
        val productPrice = findViewById<TextView>(R.id.product_price)
        val productDescription =findViewById<TextView>(R.id.product_description)

        productImage.setImageResource(image)
        productName.text = name
        productWeight.text = weight
        productPrice.text = price
        productDescription.text = description


    }
}