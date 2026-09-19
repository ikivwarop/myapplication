package com.example.myapplication.search
import com.example.myapplication.R
import com.example.myapplication.account.AccountActivity
import com.example.myapplication.cart.CartActivity
import com.example.myapplication.explore.ExploreActivity
import com.example.myapplication.favorites.FavoritesActivity
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    val productList = listOf(

            SearchProduct(R.drawable.eg, "Abhi Gold+ Brown eggs", "6pcs price", "₦81", "Eggs"),

            SearchProduct(R.drawable.egg, "Egg chicken white", "6pcs price", "₦69", "Eggs"),

            SearchProduct(R.drawable.everbest, "Everbest egg curry masala", "50gm price", "₦48", "Eggs"),

            SearchProduct(R.drawable.eggnoodles, "Egg Noodles", "2L price", "₦200", "Noodles and Pasta"),

            SearchProduct(R.drawable.eletricegg, "Eletric egg boiler", "2L price", "₦150", ""),

            SearchProduct(R.drawable.boiler, "Lifelong 2 in 1 egg boiler and poacher", "3L price", "₦120", ""))

    private lateinit var adapter: SearchAdapter

    private val filterResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == RESULT_OK) {

                    val categories = result.data?.getStringArrayListExtra("categories")
                            ?: arrayListOf()



                        val filteredList = productList.filter { product ->
                            product.category in categories
                        }

                        adapter.updateList(filteredList)
                    }
                }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)



        val recycler = findViewById<RecyclerView>(R.id.search_recyclerview)
        recycler.layoutManager = GridLayoutManager(this, 2)

         adapter = SearchAdapter(emptyList())
        recycler.adapter = adapter


        val searchEditText = findViewById<EditText>(R.id.search_edit_text)

        searchEditText.addTextChangedListener { text ->

            val searchText = text.toString().trim()

            if (searchText.isEmpty()) {
                adapter.updateList(emptyList())
            } else {
                val filteredList = productList.filter { product ->
                    product.name.contains(searchText, ignoreCase = true)
                }
                adapter.updateList(filteredList)
            }
        }

        val shop = findViewById<LinearLayout>(R.id.shop_layout)
        shop.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val explore = findViewById<LinearLayout>(R.id.explore_label)
        explore.setOnClickListener {
            val intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
            finish()
        }
        val cart = findViewById<LinearLayout>(R.id.cart_label)
        cart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val favorite = findViewById<LinearLayout>(R.id.favorite_love_label)
        favorite.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
            finish()
        }

        val account = findViewById<LinearLayout>(R.id.account_label)
        account.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish()
        }
        val filterButton = findViewById<ImageView>(R.id.filter_button)
        filterButton.setOnClickListener{
            val intent = Intent(this, FilterActivity::class.java)
            filterResult.launch(intent)
        }

        findViewById<ImageView>(R.id.clear_search).setOnClickListener {
            searchEditText.text.clear()
        }
    }
    }







