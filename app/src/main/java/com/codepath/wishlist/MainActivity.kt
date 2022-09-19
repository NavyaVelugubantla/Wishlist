package com.codepath.wishlist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var productList : MutableList<Wishlist> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEntered = findViewById<EditText>(R.id.nameET)
        var priceEntered = findViewById<EditText>(R.id.priceET)
        var urlEntered = findViewById<EditText>(R.id.urlET)
        var button = findViewById<Button>(R.id.add)

        // Lookup the recyclerview in activity layout
        val rvWishlist = findViewById<View>(R.id.wishlistRV) as RecyclerView
        // Fetch the list of emails
        val products = productList

        // Create adapter passing in the sample user data
        val adapter = WishlistAdapter(products)
        // Attach the adapter to the recyclerview to populate items
        rvWishlist.adapter = adapter
        // Set layout manager to position the items
        rvWishlist.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener() {
            val prod = Wishlist(nameEntered.text.toString(), priceEntered.text.toString(), urlEntered.text.toString())
            products.add(prod)
            adapter.notifyDataSetChanged()
            it.hideKeyboard()
            nameEntered.setText("")
            priceEntered.setText("")
            urlEntered.setText("")
        }
    }

    private fun View.hideKeyboard()
    {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}