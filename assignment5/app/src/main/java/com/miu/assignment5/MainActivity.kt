package com.miu.assignment5

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private val quizList = ArrayList<Quiz>()

    private lateinit var radioOption1: RadioButton
    private lateinit var radioOption2: RadioButton
    private lateinit var radioOption3: RadioButton

    private lateinit var checkboxOption1: CheckBox
    private lateinit var checkboxOption2: CheckBox
    private lateinit var checkboxOption3: CheckBox

    private var answer1 = ""
    private var answer2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initQuizQuestionsAnswers()

        initViews()
    }

    private fun initViews() {
        radioOption1 = findViewById(R.id.radio_option1_q1)
        radioOption2 = findViewById(R.id.radio_option2_q1)
        radioOption3 = findViewById(R.id.radio_option3_q1)

        checkboxOption1 = findViewById(R.id.checkbox_option1_q2)
        checkboxOption2 = findViewById(R.id.checkbox_option2_q2)
        checkboxOption3 = findViewById(R.id.checkbox_option3_q2)
    }

    private fun initQuizQuestionsAnswers() {
        val quiz1 = Quiz(
            "B",
            1
        )

        val quiz2 = Quiz(
            "AB",
            2
        )

        quizList.add(0, quiz1)
        quizList.add(1, quiz2)
    }

    fun onResetClicked(view: View) {

        //reset question 1 options
        radioOption1.isChecked = false
        radioOption2.isChecked = false
        radioOption3.isChecked = false

        //reset question 2 options
        checkboxOption1.isChecked = false
        checkboxOption2.isChecked = false
        checkboxOption3.isChecked = false

        //reset answer variable
        answer1 = ""
        answer2 = ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmitClicked(view: View) {

        var score = 0

        val current = LocalDateTime.now()

        //get date
        val formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = current.format(formatterDate)

        //get time
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss")
        val time = current.format(formatterTime)

        readAnswer2()

        if (validateAnswer1()) {
            score += 50
        }
        if (validateAnswer2()) {
            score += 50
        }

        val messageToDisplay =
            "Congratulations! You submitted on current Date: $date and Time: $time, You achieved $score %"

        displayDialog(messageToDisplay, "Your Quiz Score is here..")
    }

    private fun displayDialog(message: String, title: String) {
        val builder: AlertDialog.Builder = this.let {
            AlertDialog.Builder(it)
        }

        builder.setMessage(message)!!.setTitle(title)

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun validateAnswer1(): Boolean {
        val quiz = quizList[0] // accessing first quiz
        if (quiz.answer == answer1) {
            return true
        }
        return false
    }

    private fun validateAnswer2(): Boolean {
        val quiz = quizList[1] // accessing first quiz
        if (quiz.answer == answer2) {
            return true
        }
        return false
    }

    private fun readAnswer2() {
        answer2 = ""
        if (checkboxOption1.isChecked) {
            answer2 += "A"
        }
        if (checkboxOption2.isChecked) {
            answer2 += "B"
        }

        if (checkboxOption3.isChecked) {
            answer2 += "C"
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_option1_q1 ->
                    if (checked) {
                        answer1 = "A"
                    }
                R.id.radio_option2_q1 ->
                    if (checked) {
                        answer1 = "B"
                    }

                R.id.radio_option3_q1 ->
                    if (checked) {
                        answer1 = "C"
                    }
            }
        }
    }

}