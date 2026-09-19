package com.example.myapplication.explore
import com.example.myapplication.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private data class CategoryListing(val title: String, val products: List<CategoryProduct>)

class CategoryProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_products)

        val category = intent.getStringExtra("category")
        val listing = categoryListing(category) ?: categoryListing("beverages")!!

        findViewById<TextView>(R.id.category_title).text = listing.title
        findViewById<ImageView>(R.id.back_arrow).setOnClickListener { finish() }

        val recycler = findViewById<RecyclerView>(R.id.beverages_recyclerview)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = CategoryProductAdapter(listing.products) { }
    }

    private fun categoryListing(category: String?): CategoryListing? = when (category) {
        "beverages" -> CategoryListing("Beverages", listOf(
                CategoryProduct(R.drawable.dietcoke, "Diet coke", "355ml, price", "₦40"),
                CategoryProduct(R.drawable.sprite, "Sprite can", "325ml, price", "₦45"),
                CategoryProduct(R.drawable.realfruit, "Real fruit power cranberry juice", "1L, price", "₦150"),
                CategoryProduct(R.drawable.maaza, "maaza mango drink", "1L, price", "₦150"),
                CategoryProduct(R.drawable.cocacola, "cocacola can", "325ml, price", "₦50"),
                CategoryProduct(R.drawable.pepsi, "pepsi can", "330ml price", "₦50")
        ))
        "dairy_eggs" -> CategoryListing("Dairy and eggs", listOf(
                CategoryProduct(R.drawable.eg, "Abhi Gold+ Brown eggs", "6pcs price", "₦81"),
                CategoryProduct(R.drawable.egg, "Egg chicken white", "6pcs price", "₦69"),
                CategoryProduct(R.drawable.everbest, "Everbest egg curry masala", "50gm price", "₦48"),
                CategoryProduct(R.drawable.eggnoodles, "Egg Noodles", "2L price", "₦200"),
                CategoryProduct(R.drawable.eletricegg, "Eletric egg boiler", "2L price", "₦150"),
                CategoryProduct(R.drawable.boiler, "Lifelong 2 in 1 egg boiler and poacher", "3L price", "₦120")
        ))
        "fresh_fruits" -> CategoryListing("Fresh fruits and vegetables", listOf(
                CategoryProduct(R.drawable.twoapple, "Red apple", "1kg, price", "₦150"),
                CategoryProduct(R.drawable.banana, "Organic banana", "7pcs, price", "₦100"),
                CategoryProduct(R.drawable.fruit, "Mixed fruit basket", "1kg, price", "₦300"),
                CategoryProduct(R.drawable.ginger, "Fresh ginger", "250gm, price", "₦60")
        ))
        "cooking_oil" -> CategoryListing("Cooking oil and ghee", listOf(
                CategoryProduct(R.drawable.coconutoil, "Coconut oil", "1L, price", "₦250")
        ))
        "meat_fish" -> CategoryListing("Meat and fish", listOf(
                CategoryProduct(R.drawable.meat, "Fresh meat cut", "1kg, price", "₦2500")
        ))
        "bakery_snacks" -> CategoryListing("Bakery and snacks", listOf(
                CategoryProduct(R.drawable.snacks, "Assorted snacks pack", "500gm, price", "₦400")
        ))
        else -> null
    }
}