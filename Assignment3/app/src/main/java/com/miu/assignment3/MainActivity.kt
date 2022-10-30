package com.miu.assignment3

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var androidVersionEdt: EditText
    private lateinit var codeVersionEdt: EditText
    private lateinit var addBtn: Button
    private lateinit var tableLayout: TableLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing views
        initViews()

        //setting click listener to the views
        addBtn.setOnClickListener(this)

    }

    private fun initViews() {
        androidVersionEdt = findViewById(R.id.androidVersionEdt)
        codeVersionEdt = findViewById(R.id.codeNameEdt)
        addBtn = findViewById(R.id.addBtn)
        tableLayout = findViewById(R.id.tableLayout)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.addBtn -> {
                if (validateFields()) {

                    //creating table row
                    val tableRow = TableRow(applicationContext)

                    //table row property
                    tableRow.setBackgroundColor(resources.getColor(R.color.pink))

                    //table row initializes with layout param
                    val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                    tableRow.layoutParams = layoutParams

                    //Creating view dynamically to add into table row -> first column view
                    val andVersion = TextView(this)
                    andVersion.width = getWidthOfScreen()/2
                    andVersion.setPadding(20,20,20,20)
                    andVersion.setTextColor(resources.getColor(R.color.black))
                    andVersion.text = androidVersionEdt.text.toString()

                    ////Creating view dynamically to add into table row -> second column view
                    val code = TextView(this)
                    code.width = getWidthOfScreen()/2
                    code.setPadding(20,20,20,20)
                    code.setTextColor(resources.getColor(R.color.black))
                    code.text = codeVersionEdt.text.toString()

                    //adding 2 created view to the table row
                    tableRow.addView(andVersion)
                    tableRow.addView(code)

                    //adding table row to the table
                    tableLayout.addView(tableRow)

                    //after adding value to the table row, clearing the above edit text
                    androidVersionEdt.text.clear()
                    codeVersionEdt.text.clear()

                }
            }
        }
    }

    private fun getWidthOfScreen(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    private fun validateFields() : Boolean {
        if (androidVersionEdt.text.isEmpty()) {
            androidVersionEdt.error = "Field can not be empty!"
            androidVersionEdt.requestFocus()
            return false
        } else if (codeVersionEdt.text.isEmpty()) {
            codeVersionEdt.error = "Field can not be empty!"
            codeVersionEdt.requestFocus()
            return false
        }
        return true
    }


}