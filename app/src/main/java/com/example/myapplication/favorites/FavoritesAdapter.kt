package com.example.myapplication.favorites

import com.example.myapplication.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(
        private val items: List<FavoriteItem>,
        private val onClick: (FavoriteItem) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.item_image)
        val name = itemView.findViewById<TextView>(R.id.item_name)
        val weight = itemView.findViewById<TextView>(R.id.item_weight)
        val price = itemView.findViewById<TextView>(R.id.item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.weight.text = item.weight
        holder.price.text = item.price
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
