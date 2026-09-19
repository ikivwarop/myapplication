package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.beverage.GrofastbeverageActivity4

class GrofastexploreActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastexplore4)

        val findProduct = listOf(
                FindProduct("fresh_fruits", R.drawable.frshfruit, "Fresh fruits and vegetables",),
                FindProduct("cooking_oil", R.drawable.coconutoil, "Cooking oil and gree"),
                FindProduct("meat_fish", R.drawable.meat, "Meat and fish"),
                FindProduct("bakery_snacks", R.drawable.snacks, "Bakery and snacks"),
                FindProduct("dairy_eggs", R.drawable.eggs, "Dairy and eggs"),
                FindProduct("beverages", R.drawable.beveragess, "Beverages"),
                FindProduct("fresh_fruits", R.drawable.frshfruit, "Fresh fruits and vegetables"),
                FindProduct("cooking_oil", R.drawable.coconutoil, "Cooking oil and gree")

        )

                val recycler = findViewById<RecyclerView>(R.id.find_product_recyclerview)
        recycler.layoutManager =
                GridLayoutManager(this, 2)
        recycler.adapter = FindproductAdapter(findProduct) { product ->



            when(product.id){

                "beverages" -> {
                    val intent = Intent(this, GrofastbeverageActivity4::class.java)
                    
                    intent.putExtra("category", product.id )
                    startActivity(intent)
                }

                "meat_fish" ->
                    {
                        val intent = Intent(this, GrofastbeverageActivity4::class.java)
                        intent.putExtra("category", product.id )
                startActivity(intent)
                }


                "dairy_eggs" ->

                    {
                        val intent = Intent(this, GrofastbeverageActivity4::class.java)
                        intent.putExtra("category", product.id )
                startActivity(intent)
                    }

                "cooking_oil" ->
                {
                    val intent = Intent(this, GrofastbeverageActivity4::class.java)
                intent.putExtra("category", product.id)
                startActivity(intent)
                }

                "fresh_fruits" ->
                {
                    val intent = Intent(this, GrofastbeverageActivity4::class.java)
                intent.putExtra("category", product.id)
                startActivity(intent)
                }

                "bakery_snacks" -> {
                    val intent = Intent(this, GrofastbeverageActivity4::class.java)
                    intent.putExtra("category", product.id)
                    startActivity(intent)
                }

            }


        }



    val shop = findViewById<LinearLayout>(R.id.explore_shop)
        shop.setOnClickListener {

            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val myCart = findViewById<LinearLayout>(R.id.explore_cart)
        myCart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.explore_favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.explore_account)
        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
            finish()
        }

        val search = findViewById<EditText>(R.id.search_store)
        search.setOnClickListener {

            val intent = Intent(this, GrofastsearchActivity4::class.java)

            startActivity(intent)


        }
    }
}