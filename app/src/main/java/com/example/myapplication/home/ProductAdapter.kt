package com.example.myapplication.home
import com.example.myapplication.R
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
        private val productList: List<Product>,
        private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.product_image)

        val productName = itemView.findViewById<TextView>(R.id.product_name)

        val productWeight = itemView.findViewById<TextView>(R.id.product_weight)

        val productPrice = itemView.findViewById<TextView>(R.id.product_price)

        val addButton = itemView.findViewById<ImageView>(R.id.add_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.productImage.setImageResource(product.image)
        holder.productName.text = product.name
        holder.productWeight.text = product.weight
        holder.productPrice.text = product.price

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }

        // ponytail: no shared cart state yet - real add-to-cart wiring belongs with the Cart screen pass
        holder.addButton.setOnClickListener {
            Toast.makeText(it.context, "${product.name} added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
