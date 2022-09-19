package com.codepath.wishlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val products: List<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    inner class ViewHolder(productView: View) : RecyclerView.ViewHolder(productView) {
        val nameTextView = productView.findViewById<TextView>(R.id.nameTV)
        val priceTextView = productView.findViewById<TextView>(R.id.priceTV)
        val urlTextView = productView.findViewById<TextView>(R.id.urlTV);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val productsView = inflater.inflate(R.layout.wishlist_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(productsView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WishlistAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val product: Wishlist = products.get(position)
        // Set item views based on your views and data model

        viewHolder.nameTextView.setText(product.productName)
        viewHolder.priceTextView.setText(product.productPrice)
        viewHolder.urlTextView.setText(product.productURL)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return products.size
    }
}