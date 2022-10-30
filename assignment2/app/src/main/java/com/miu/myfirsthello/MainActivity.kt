package com.miu.myfirsthello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName
    private var defaultFoods = arrayOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    private lateinit var addFood: Button
    private lateinit var newFoodTxt: EditText
    private lateinit var foodNameTxt : TextView

    private val foodList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing views
        addFood = findViewById(R.id.addFoodBtn)
        newFoodTxt = findViewById(R.id.newFoodTxt)
        foodNameTxt = findViewById(R.id.foodNameTxt)
        val decideBtn:Button = findViewById(R.id.decideBtn)

        foodList.addAll(defaultFoods)

        addFood.setOnClickListener {
            if (!newFoodTxt.text.isNullOrEmpty()) {
                foodList.add(newFoodTxt.text.toString())
                newFoodTxt.text.clear()
            }
        }
        decideBtn.setOnClickListener {
            //get random number
            val randomIndex = Random.nextInt(0, foodList.size)

            //get food name according to random value
            val foodName = foodList[randomIndex]

            //set value to the text view
            foodNameTxt.text = foodName

        }
    }

}
