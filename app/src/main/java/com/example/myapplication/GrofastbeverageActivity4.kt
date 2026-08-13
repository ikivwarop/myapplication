package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GrofastbeverageActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastbeverage4)

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
        recycler.adapter = BeveragesAdapter(beveragesList) {beverage ->


        }
    }
}