package com.example.myapplication

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

class GrofastsearchActivity4 : AppCompatActivity() {



    private lateinit var adapter: SearchAdapter
    private lateinit var searchEditText: EditText
    private var filteredProductList = emptyList<SearchProduct>()
    private var isFilterActive = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastsearch4)

        val productList = listOf(

                SearchProduct(R.drawable.eg, "Abhi Gold+ Brown eggs", "6pcs price", "₦81", "Eggs"),

                SearchProduct(R.drawable.egg, "Egg chicken white", "6pcs price", "₦69", "Eggs"),

                SearchProduct(R.drawable.everbest, "Everbest egg curry masala", "50gm price", "₦48", "Eggs"),

                SearchProduct(R.drawable.eggnoodles, "Egg Noodles", "2L price", "₦200", "Noodles and Pasta"),

                SearchProduct(R.drawable.eletricegg, "Eletric egg boiler", "2L price", "₦150", ""),

                SearchProduct(R.drawable.boiler, "Lifelong 2 in 1 egg boiler and poacher", "3L price", "₦120", ""))

         val filterResult =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                    if (result.resultCode == RESULT_OK) {

                        val categories = result.data?.getStringArrayListExtra("categories")
                                ?: arrayListOf()



                        filteredProductList = productList.filter { product ->
                            product.category in categories
                        }

                        isFilterActive = categories.isNotEmpty()

                        searchEditText.text.clear()

                        adapter.updateList(filteredProductList)
                    }
                }

        val recycler = findViewById<RecyclerView>(R.id.search_recyclerview)
        recycler.layoutManager = GridLayoutManager(this, 2)

         adapter = SearchAdapter(emptyList())
        recycler.adapter = adapter


         searchEditText = findViewById(R.id.search_edit_text)

        searchEditText.addTextChangedListener { text ->

            val searchText = text.toString().trim()

            if (searchText.isEmpty()) {
                if (isFilterActive) {
                    adapter.updateList(filteredProductList)
                } else {
                    adapter.updateList(emptyList())
                }
            } else {
                val filteredList = productList.filter { product ->
                    product.name.contains(searchText, ignoreCase = true)
                }
                adapter.updateList(filteredList)
            }
        }

        val shop = findViewById<LinearLayout>(R.id.shop_layout)
        shop.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
        }

        val explore = findViewById<LinearLayout>(R.id.explore_label)
        explore.setOnClickListener {
            val intent = Intent(this, GrofastexploreActivity4::class.java)
            startActivity(intent)
        }
        val cart = findViewById<LinearLayout>(R.id.cart_label)
        cart.setOnClickListener {
            val intent = Intent(this, GrofastmycartActivity4::class.java)
            startActivity(intent)
        }

        val favorite = findViewById<LinearLayout>(R.id.favorite_love_label)
        favorite.setOnClickListener {
            val intent = Intent(this, GrofastfavoritesActivity4::class.java)
            startActivity(intent)
        }

        val account = findViewById<LinearLayout>(R.id.account_label)
        account.setOnClickListener {
            val intent = Intent(this, GrofastaccountActivity4::class.java)
            startActivity(intent)
        }
        val filterButton = findViewById<ImageView>(R.id.filter_button)
        filterButton.setOnClickListener{
            val intent = Intent(this, GrofastfilterActivity4::class.java)
            filterResult.launch(intent)
        }
    }
    }







