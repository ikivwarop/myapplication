package com.example.myapplication.cart

import com.example.myapplication.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
        private val items: List<CartItem>,
        private val onChanged: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.item_image)
        val name = itemView.findViewById<TextView>(R.id.item_name)
        val weight = itemView.findViewById<TextView>(R.id.item_weight)
        val price = itemView.findViewById<TextView>(R.id.item_price)
        val quantity = itemView.findViewById<TextView>(R.id.quantity)
        val decrease = itemView.findViewById<ImageView>(R.id.decrease_quantity)
        val increase = itemView.findViewById<ImageView>(R.id.increase_quantity)
        val delete = itemView.findViewById<ImageView>(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.weight.text = item.weight
        holder.price.text = item.price
        holder.quantity.text = item.quantity.toString()

        holder.decrease.setOnClickListener {
            CartManager.changeQuantity(item, -1)
            onChanged()
        }
        holder.increase.setOnClickListener {
            CartManager.changeQuantity(item, 1)
            onChanged()
        }
        holder.delete.setOnClickListener {
            CartManager.remove(item)
            onChanged()
        }
    }

    override fun getItemCount(): Int = items.size
}
