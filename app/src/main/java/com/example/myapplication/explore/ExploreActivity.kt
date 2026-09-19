package com.example.myapplication.explore
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.cart.CartActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.search.SearchActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        val findProduct = listOf(
                ExploreCategory("fresh_fruits", R.drawable.frshfruit, "Fresh fruits and vegetables",),
                ExploreCategory("cooking_oil", R.drawable.coconutoil, "Cooking oil and gree"),
                ExploreCategory("meat_fish", R.drawable.meat, "Meat and fish"),
                ExploreCategory("bakery_snacks", R.drawable.snacks, "Bakery and snacks"),
                ExploreCategory("dairy_eggs", R.drawable.eggs, "Dairy and eggs"),
                ExploreCategory("beverages", R.drawable.beveragess, "Beverages"),
                ExploreCategory("fresh_fruits", R.drawable.frshfruit, "Fresh fruits and vegetables"),
                ExploreCategory("cooking_oil", R.drawable.coconutoil, "Cooking oil and gree")

        )

                val recycler = findViewById<RecyclerView>(R.id.find_product_recyclerview)
        recycler.layoutManager =
                GridLayoutManager(this, 2)
        recycler.adapter = ExploreCategoryAdapter(findProduct) { product ->



            when(product.id){

                "beverages" -> {
                    val intent = Intent(this, CategoryProductsActivity::class.java)
                    
                    intent.putExtra("category", product.id )
                    startActivity(intent)
                }

                "meat_fish" ->
                    {
                        val intent = Intent(this, CategoryProductsActivity::class.java)
                        intent.putExtra("category", product.id )
                startActivity(intent)
                }


                "dairy_eggs" ->

                    {
                        val intent = Intent(this, CategoryProductsActivity::class.java)
                        intent.putExtra("category", product.id )
                startActivity(intent)
                    }

                "cooking_oil" ->
                {
                    val intent = Intent(this, CategoryProductsActivity::class.java)
                intent.putExtra("category", product.id)
                startActivity(intent)
                }

                "fresh_fruits" ->
                {
                    val intent = Intent(this, CategoryProductsActivity::class.java)
                intent.putExtra("category", product.id)
                startActivity(intent)
                }

                "bakery_snacks" -> {
                    val intent = Intent(this, CategoryProductsActivity::class.java)
                    intent.putExtra("category", product.id)
                    startActivity(intent)
                }

            }


        }



    val shop = findViewById<LinearLayout>(R.id.explore_shop)
        shop.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val myCart = findViewById<LinearLayout>(R.id.explore_cart)
        myCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.explore_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.explore_account)
        account.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish()
        }

        val search = findViewById<EditText>(R.id.search_store)
        search.setOnClickListener {

            val intent = Intent(this, SearchActivity::class.java)

            startActivity(intent)


        }
    }
}