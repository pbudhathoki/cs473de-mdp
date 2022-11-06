package com.miu.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.google.gson.Gson
import com.miu.assignment4.databinding.ActivityShoppingCategoryBinding

class activity_shopping_category : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ss: String = intent.getStringExtra("username").toString()
        binding.welcomeText.text = "Welcome: $ss"

        binding.beautyLayout.setOnClickListener {
            showToast("Beauty")
        }
        binding.clothingLayout.setOnClickListener {
            showToast("Clothing")
        }
        binding.electronicLayout.setOnClickListener {
            val electronicItemList = ArrayList<Product>()
            val product1 = Product(
                "Iphone 12 Pro",
                1050.00,
                "Gold",
                "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iphone12pro-stainless-steel-gold_10132020_inline.jpg.large.jpg",
                "APP1",
                "Refubrished Iphone in excellenet condition"
            )

            val product2 = Product(
                "Fire HD tablet",
                44.99,
                "Black",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ22mTEXQPtES08BbSaDaML1UHJ9IfWyvd6ng&usqp=CAU",
                "FHD123",
                "8\" HD display, 2X the storage (32 or 64 GB of internal storage and up to 1 TB with microSD card) + 2 GB RAM. 10th generation (2020 release)."
            )

            val product3 = Product(
                "JBL Flip 4 Waterproof Portable Bluetooth",
                69.99,
                "Grey",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7JJ382lU4sC3H0-G3QGyApjsEduhyQvr7BbGyBlMLq685ipMgKUwZSWMg2WDyhDKmAqM&usqp=CAU",
                "JBL2525",
                "Wirelessly connect up to 2 smartphones or tablets to the speaker and take turns playing impressive stereo sound."
            )
            val product4 = Product(
                "Nintendo Switch",
                299.00,
                "Blue",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPcV1wqcwTJwvNCFR_plA7TB3Z0oRY2_RA30DPZgrwU9TYa9PyoeElnZV6wAn9MULsecE&usqp=CAU",
                "HAC01",
                "3 Play Styles: TV Mode, Tabletop Mode, Handheld Mode"
            )

            val product5 = Product(
                "TCL 40\" Class 3-Series Full HD 1080p LED Smart Roku TV ",
                199.99,
                "black",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-yFTyqgcDS19-j9u777D4uUM9Cpps-L-JIQ&usqp=CAU",
                "40S3",
                "Stunning Full HD: Stunning Full HD resolution offers enhanced clarity and detail for all your favorite entertainment"
            )

            electronicItemList.add(product1)
            electronicItemList.add(product2)
            electronicItemList.add(product3)
            electronicItemList.add(product4)
            electronicItemList.add(product5)

            goToProductListActivity(electronicItemList)

        }
        binding.foodLayout.setOnClickListener {
            showToast("Food")
        }

    }

    private fun goToProductListActivity(productList: ArrayList<Product>) {
        val intent = Intent(this, ActivityProduct::class.java)
        intent.putExtra("productList", Gson().toJson(productList))
        startActivity(intent)
    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this,
            "You have chosen the $msg category of shopping",
            Toast.LENGTH_SHORT
        )
            .show()
    }
}