package com.example.myapplication

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.contracts.Returns

class PlusesAdapter3 (

        private val productList: List<Pluses3>
) : RecyclerView.Adapter<PlusesAdapter3.ProductViewHolder>() {

    class ProductViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        val productImage = itemView.findViewById<ImageView>(R.id.product_pluses_image3)
        val productName = itemView.findViewById<TextView>(R.id.product_pluses_name3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pluses3, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product =productList[position]

        holder.productImage.setImageResource(product.image)
        holder.productName.text = product.name
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}