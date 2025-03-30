package com.example.menuapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var timeInput: EditText? = null
    private var mealTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        timeInput = findViewById(R.id.timeInput)
        mealTxt = findViewById(R.id.mealTxt)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val enterBtn = findViewById<Button>(R.id.enterBtn)
        val mealTxt = findViewById<TextView>(R.id.mealTxt)
        val resetBtn = findViewById<Button>(R.id.resetBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        enterBtn.setOnClickListener {
            mealRecommend()
        }
        resetBtn.setOnClickListener {
            timeInput?.setText("")
            mealTxt?.text = ""
        }
        exitBtn.setOnClickListener {
            exitProcess(-1)
        }
    }

    private fun mealRecommend() {
        if (empty()) {
            if (timeInput?.text.toString().trim() == "Morning") {
                mealTxt?.text = "Eggs and Bacon"
            } else if (timeInput?.text.toString().trim() == "Mid-Morning") {
                mealTxt?.text = "Avo on Toast"
            } else if (timeInput?.text.toString().trim() == "Afternoon") {
                mealTxt?.text = "Peanut Butter Sandwich"
            } else if (timeInput?.text.toString().trim() == "Mid-Afternoon") {
                mealTxt?.text = "Yogurt"
            } else if (timeInput?.text.toString().trim() == "Evening") {
                mealTxt?.text = "Chicken and Rice"
            } else if (empty()){
                timeInput?.error = "Check Spelling"
                mealTxt?.text = ""
            }
        }
    }

    private fun empty(): Boolean {
        var b = true
        if (timeInput?.text.toString().trim().isEmpty()) {
            timeInput?.error = "Enter Time of Day"
            mealTxt?.text = ""
            b = false
        }
        return b
    }
}