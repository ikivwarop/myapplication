package com.example.myapplication.beverage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BeveragesAdapter
import com.example.myapplication.BeveragesProduct
import com.example.myapplication.R

class GrofastbeverageActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastbeverage4)

        val category = intent.getStringExtra("category")

        if (category == "beverages") {

            val beveragesList = listOf(

                    BeveragesProduct(
                            R.drawable.dietcoke,
                            "Diet coke",
                            "355ml, price",
                            "₦40"
                    ),

                    BeveragesProduct(
                            R.drawable.sprite,
                            "Sprite can",
                            "325ml, price",
                            "₦45"
                    ),
                    BeveragesProduct(
                            R.drawable.realfruit,
                            "Real fruit power cranberry juice",
                            "1L, price",
                            "₦150"
                    ),

                    BeveragesProduct(
                            R.drawable.maaza,
                            "maaza mango drink",
                            "1L, price",
                            "₦150"
                    ),
                    BeveragesProduct(
                            R.drawable.cocacola,
                            "cocacola can",
                            "325ml, price",
                            "₦50"
                    ),
                    BeveragesProduct(
                            R.drawable.pepsi,
                            "pepsi can",
                            "330ml price",
                            "₦50"
                    )
            )

            val recycler = findViewById<RecyclerView>(R.id.beverages_recyclerview)
            recycler.layoutManager = GridLayoutManager(this, 2)
            recycler.adapter = BeveragesAdapter(beveragesList) { beverage ->


            }
        }

        if (category == "dairy_eggs") {

            val dairyList = listOf(

                    BeveragesProduct(
                            R.drawable.eg,
                            "Abhi Gold+ Brown eggs",
                            "6pcs price",
                            "₦81"
                    ),
                    BeveragesProduct(
                            R.drawable.egg,
                            "Egg chicken white",
                            "6pcs price",
                            "₦69"
                    ),

                    BeveragesProduct(
                            R.drawable.everbest,
                            "Everbest egg curry masala",
                            "50gm price",
                            "₦48"
                    ),

                    BeveragesProduct(
                            R.drawable.eggnoodles,
                            "Egg Noodles",
                            "2L price",
                            "₦200"
                    ),

                    BeveragesProduct(
                            R.drawable.eletricegg,
                            "Eletric egg boiler",
                            "2L price",
                            "₦150"
                    ),

                    BeveragesProduct(
                            R.drawable.boiler,
                            "Lifelong 2 in 1 egg boiler and poacher",
                            "3L price",
                            "₦120"
                    )
            )
            val recycler = findViewById<RecyclerView>(R.id.beverages_recyclerview)
            recycler.layoutManager = GridLayoutManager(this, 2)
            recycler.adapter = BeveragesAdapter(dairyList) { beverage ->


            }

        }


    }
}