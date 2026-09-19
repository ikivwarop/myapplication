package com.example.myapplication

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(

        private var searchList: List<SearchProduct>
): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.product_image)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val productWeight = itemView.findViewById<TextView>(R.id.product_weight)
        val productPrice = itemView.findViewById<TextView>(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.search_product, parent, false)
        return SearchViewHolder(view)

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val search = searchList [position]
        holder.productImage.setImageResource(search.image)
        holder.productName.text = search.name
        holder.productWeight.text = search.weight
        holder.productPrice.text = search.price
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    fun updateList(newList: List<SearchProduct>){
        searchList = newList
        notifyDataSetChanged()
    }
}