package com.example.myapplication.explore
import com.example.myapplication.R
import com.example.myapplication.cart.CartManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoryProductAdapter (
        private val beverages: List<CategoryProduct>,
        private val onClick: (CategoryProduct) -> Unit
) : RecyclerView.Adapter<CategoryProductAdapter.BeveragesViewHolder>(){

    class BeveragesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



    val itemImage = itemView.findViewById<ImageView>(R.id.item_image)
    val itemName = itemView.findViewById<TextView>(R.id.item_name)
    val itemWeight = itemView.findViewById<TextView>(R.id.item_weight)
    val itemPrice = itemView.findViewById<TextView>(R.id.item_price)
    val itemAdd = itemView.findViewById<ImageView>(R.id.item_add)

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

        holder.itemAdd.setOnClickListener {
            CartManager.add(beverage.image, beverage.name, beverage.weight, beverage.price)
            Toast.makeText(it.context, "${beverage.name} added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return beverages.size
    }
}
