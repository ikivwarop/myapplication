package com.example.myapplication.search
import com.example.myapplication.R
import com.example.myapplication.cart.CartManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(

        private var searchList: List<SearchProduct>
): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.product_image)
        val productName = itemView.findViewById<TextView>(R.id.product_name)
        val productWeight = itemView.findViewById<TextView>(R.id.product_weight)
        val productPrice = itemView.findViewById<TextView>(R.id.product_price)
        val addButton = itemView.findViewById<ImageView>(R.id.add_button)
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

        holder.addButton.setOnClickListener {
            CartManager.add(search.image, search.name, search.weight, search.price)
            Toast.makeText(it.context, "${search.name} added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    fun updateList(newList: List<SearchProduct>){
        searchList = newList
        notifyDataSetChanged()
    }
}