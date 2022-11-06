package com.miu.assignment4.handlers

import com.miu.assignment4.Product

interface ProductClickListener {
    fun onProductItemClicked(product: Product)
}