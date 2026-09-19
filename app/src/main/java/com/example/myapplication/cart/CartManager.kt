package com.example.myapplication.cart

data class CartItem(
        val image: Int,
        val name: String,
        val weight: String,
        val price: String,
        var quantity: Int = 1
)

// ponytail: in-memory only, resets on process death - swap for persisted storage if the cart needs to survive app restarts
object CartManager {
    private val items = mutableListOf<CartItem>()

    fun add(image: Int, name: String, weight: String, price: String, quantity: Int = 1) {
        val existing = items.find { it.name == name }
        if (existing != null) {
            existing.quantity += quantity
        } else {
            items.add(CartItem(image, name, weight, price, quantity))
        }
    }

    fun remove(item: CartItem) {
        items.remove(item)
    }

    fun changeQuantity(item: CartItem, delta: Int) {
        item.quantity = (item.quantity + delta).coerceAtLeast(1)
    }

    fun getItems(): List<CartItem> = items

    fun clear() {
        items.clear()
    }

    fun totalPrice(): Int = items.sumOf { priceValue(it.price) * it.quantity }

    private fun priceValue(price: String): Int = price.filter { it.isDigit() }.toIntOrNull() ?: 0
}
