package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeveragesAdapter (
        private val beverages: List<BeveragesProduct>,
        private val onClick: (BeveragesProduct) -> Unit
) : RecyclerView.Adapter<BeveragesAdapter.BeveragesViewHolder>(){

    class BeveragesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



    val itemImage = itemView.findViewById<ImageView>(R.id.item_image)
    val itemName = itemView.findViewById<TextView>(R.id.item_name)
    val itemWeight = itemView.findViewById<TextView>(R.id.item_weight)
    val itemPrice = itemView.findViewById<TextView>(R.id.item_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeveragesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.beverages_item, parent, false)
        return BeveragesViewHolder(view)

    }

    override fun onBindViewHolder(holder: BeveragesViewHolder, position: Int) {
        val beverage = beverages[position]
        holder.itemImage.setImageResource(beverage.image)
        holder.itemName.text = beverage.name
        holder.itemWeight.text = beverage.weight
        holder.itemPrice.text = beverage.price
        holder.itemView.setOnClickListener {
            onClick(beverage)
        }
    }

    override fun getItemCount(): Int {
        return beverages.size
    }
}
