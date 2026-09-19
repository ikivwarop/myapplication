package com.example.myapplication.favorites

data class FavoriteItem(
        val image: Int,
        val name: String,
        val weight: String,
        val price: String
)

// ponytail: in-memory only, resets on process death - swap for persisted storage if favorites need to survive app restarts
object FavoritesManager {
    private val items = mutableListOf<FavoriteItem>()

    fun toggle(image: Int, name: String, weight: String, price: String): Boolean {
        val existing = items.find { it.name == name }
        return if (existing != null) {
            items.remove(existing)
            false
        } else {
            items.add(FavoriteItem(image, name, weight, price))
            true
        }
    }

    fun isFavorite(name: String): Boolean = items.any { it.name == name }

    fun remove(item: FavoriteItem) {
        items.remove(item)
    }

    fun getItems(): List<FavoriteItem> = items
}
