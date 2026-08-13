package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GrofasthomescreenActivity4 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofasthomescreen4)


        val productList = listOf(
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100" ,
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts."),
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts.")

        )

        val recyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)

        recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = ProductAdapter(productList) { product ->

            val intent = Intent(this, GrofastproductdetailActivity4::class.java)

            intent.putExtra("image", product.image)
            intent.putExtra("name", product.name)
            intent.putExtra("weight", product.weight)
            intent.putExtra("price", product.price)
            intent.putExtra("description", product.description)

            startActivity(intent)
        }
        val productList2 = listOf(
                Product2(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product2(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts."),
                Product2(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product2(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts.")
        )

        val recycler = findViewById<RecyclerView>(R.id.recycler_product2)

        recycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recycler.adapter = ProductAdapter2(productList2) { product2 ->
            val intent = Intent(this, GrofastproductdetailActivity4::class.java)
            intent.putExtra("image", product2.image)
            intent.putExtra("name", product2.name)
            intent.putExtra("weight", product2.weight)
            intent.putExtra("price", product2.price)
            intent.putExtra("description", product2.description)

            startActivity(intent)
        }

        val productList3 = listOf(
                Pluses3(R.drawable.pluses, "Pulses"),
                Pluses3(R.drawable.pluse, "Rice")
        )

        val recyclerPluses = findViewById<RecyclerView>(R.id.recycler_pluses)

        recyclerPluses.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerPluses.adapter = PlusesAdapter3(productList3)

        val productList4 = listOf(
                Product4(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals"),
                Product4(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts."),
                Product4(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals"),
                Product4(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts.")
        )

        val recyclerProduct4 = findViewById<RecyclerView>(R.id.recycler_product4)

        recyclerProduct4.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerProduct4.adapter = ProductAdapter4(productList4) {product4 ->
            val intent = Intent(this, GrofastproductdetailActivity4::class.java)
            intent.putExtra("image", product4.productImage)
            intent.putExtra("name", product4.productName)
            intent.putExtra("weight", product4.productWeight)
            intent.putExtra("price", product4.productPrice)
            intent.putExtra("description", product4.productDescription)
            startActivity(intent)
        }


        val explore = findViewById<LinearLayout>(R.id.explore)
        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
            finish()

        }
        val myCart = findViewById<LinearLayout>(R.id.my_cart_label)
        myCart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.account)
        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
            finish()
        }
    }
}