package com.example.myapplication.product
import com.example.myapplication.R
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProductDetailActivity :   AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

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

        findViewById<ImageView>(R.id.left_icon).setOnClickListener { finish() }

        findViewById<ImageView>(R.id.right_icon).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out $name for $price on GroFast!")
            }
            startActivity(Intent.createChooser(shareIntent, null))
        }

        val quantityLabel = findViewById<TextView>(R.id.quantity)
        var quantity = 1
        findViewById<ImageView>(R.id.decrease_quantity).setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityLabel.text = quantity.toString()
            }
        }
        findViewById<ImageView>(R.id.increase_quantity).setOnClickListener {
            quantity++
            quantityLabel.text = quantity.toString()
        }

        val productDetailsHeader = findViewById<TextView>(R.id.product_details)
        val productDetailsChevron = findViewById<ImageView>(R.id.details_chevron)
        productDetailsHeader.setOnClickListener {
            val expanded = productDescription.maxLines > 4
            productDescription.maxLines = if (expanded) 4 else Int.MAX_VALUE
            productDetailsChevron.rotation = if (expanded) 0f else 180f
        }
        productDetailsChevron.setOnClickListener { productDetailsHeader.performClick() }

        // ponytail: no shared cart state yet - real add-to-cart wiring belongs with the Cart screen pass
        findViewById<Button>(R.id.button).setOnClickListener {
            Toast.makeText(this, "$name added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}