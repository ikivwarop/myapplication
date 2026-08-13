package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter4 (

        private val productList: List<Product4>,
        private val onItemClick: (Product4) -> Unit
) : RecyclerView.Adapter<ProductAdapter4.ProductViewHolder> () {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productImage = itemView.findViewById<ImageView>(R.id.product_image4)
        val productName = itemView.findViewById<TextView>(R.id.product_name4)
        val productWeight = itemView.findViewById<TextView>(R.id.product_weight4)
        val productPrice = itemView.findViewById<TextView>(R.id.product_price4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product4, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.productImage.setImageResource(product.productImage)
        holder.productName.text = product.productName
        holder.productWeight.text = product.productWeight
        holder.productPrice.text = product.productPrice

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}