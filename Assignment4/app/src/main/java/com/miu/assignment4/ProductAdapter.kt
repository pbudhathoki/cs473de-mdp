package com.miu.assignment4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miu.assignment4.R
import com.miu.assignment4.Product
import com.miu.assignment4.handlers.ProductClickListener

class ProductAdapter(
    private var productList: MutableList<Product> = mutableListOf(),
    private val clickLister: ProductClickListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val tvPrice: TextView = view.findViewById(R.id.tvPrice)
            val tvColor: TextView = view.findViewById(R.id.tvColor)
            val imgLogo: ImageView = view.findViewById(R.id.imgLogo)

            tvTitle.text = product.title
            tvPrice.text = "$" + product.price
            tvColor.text = product.color
            Glide.with(view.context).load(product.image).into(imgLogo)

            view.setOnClickListener {
                clickLister.onProductItemClicked(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.apply {
            bind(productList[position])
        }
    }

    override fun getItemCount(): Int = productList.size
}