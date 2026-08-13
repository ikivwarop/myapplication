package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FindproductAdapter (

    private val findProduct: List<FindProduct>,
        private val onClick: (FindProduct) -> Unit
) : RecyclerView.Adapter<FindproductAdapter.ProductViewHolder>(){

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.find_product_image)
        val productName = itemView.findViewById<TextView>(R.id.find_product_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.findproduct, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = findProduct[position]

        holder.productImage.setImageResource(product.image)
        holder.productName.text = product.name
        holder.itemView.setOnClickListener {
            onClick(product)
        }
    }

    override fun getItemCount(): Int {
        return findProduct.size
    }
}