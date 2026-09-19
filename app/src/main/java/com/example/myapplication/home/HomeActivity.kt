package com.example.myapplication.home
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.cart.CartActivity
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.product.ProductDetailActivity
import com.example.myapplication.search.SearchActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


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

            val intent = Intent(this, ProductDetailActivity::class.java)

            intent.putExtra("image", product.image)
            intent.putExtra("name", product.name)
            intent.putExtra("weight", product.weight)
            intent.putExtra("price", product.price)
            intent.putExtra("description", product.description)

            startActivity(intent)
        }
        val productList2 = listOf(
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts."),
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals."),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts.")
        )

        val recycler = findViewById<RecyclerView>(R.id.recycler_product2)

        recycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recycler.adapter = ProductAdapter(productList2) { product2 ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("image", product2.image)
            intent.putExtra("name", product2.name)
            intent.putExtra("weight", product2.weight)
            intent.putExtra("price", product2.price)
            intent.putExtra("description", product2.description)

            startActivity(intent)
        }

        val productList3 = listOf(
                CategoryTile(R.drawable.pluses, "Pulses"),
                CategoryTile(R.drawable.pluse, "Rice")
        )

        val recyclerPluses = findViewById<RecyclerView>(R.id.recycler_pluses)

        recyclerPluses.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerPluses.adapter = CategoryTileAdapter(productList3)

        val productList4 = listOf(
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals"),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts."),
                Product(R.drawable.banana, "Organic Banana", "7pcs, Price", "₦100",
                        "Fresh organic bananas rich in potassium and perfect for smoothies, snacks and healthy meals"),
                Product(R.drawable.twoapple, "Red apple", "1kg, Price", "₦150",
                        "Sweet and juicy red apples picked from premium farms. Perfect for eating fresh or making desserts.")
        )

        val recyclerProduct4 = findViewById<RecyclerView>(R.id.recycler_product4)

        recyclerProduct4.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerProduct4.adapter = ProductAdapter(productList4) { product4 ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("image", product4.image)
            intent.putExtra("name", product4.name)
            intent.putExtra("weight", product4.weight)
            intent.putExtra("price", product4.price)
            intent.putExtra("description", product4.description)
            startActivity(intent)
        }


        val explore = findViewById<LinearLayout>(R.id.explore)
        explore.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()

        }
        val myCart = findViewById<LinearLayout>(R.id.my_cart_label)
        myCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }
        val favorite = findViewById<LinearLayout>(R.id.favorite)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }
        val account = findViewById<LinearLayout>(R.id.account)
        account.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish()
        }

        val searchStore = findViewById<EditText>(R.id.search_store)

        searchStore.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

}