package com.example.myapplication

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter2 (

        private val productList: List<Product2>,
        private val onItemClick: (Product2) -> Unit
) : RecyclerView.Adapter<ProductAdapter2.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.product_image2)
        val productName = itemView.findViewById<TextView>(R.id.product_name2)
        val productWeight = itemView.findViewById<TextView>(R.id.product_weight2)
        val productPrice = itemView.findViewById<TextView>(R.id.product_price2)
        val button = itemView.findViewById<ImageView>(R.id.button2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product2, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product =productList[position]

        holder.productImage.setImageResource(product.image)
        holder.productName.text = product.name
        holder.productWeight.text = product.weight
        holder.productPrice.text = product.price


        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}