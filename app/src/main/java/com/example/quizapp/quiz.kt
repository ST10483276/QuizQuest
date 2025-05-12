package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.utilities.Score

class quiz : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var BtnTrue: Button
    private lateinit var BtnFalse: Button
    private lateinit var Btn_next: Button
    private lateinit var feedbackTextView: TextView

    companion object {
        val questions = arrayOf(
            "There are 7 days in a week.",
            "Android Studio is a programming language.",
            "INTRODUCTION TO MOBILE APPLICATION DEVELOPMENT is a Bachelors.",
            "There are 24 hours in a day.",
            "There are 42 states in the United States of America."
        )
        val answers = booleanArrayOf(true, false, false, true, false)
    }

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize UI elements
        questionTextView = findViewById(R.id.questions_textView)
        BtnTrue = findViewById(R.id.BtnTrue)
        BtnFalse = findViewById(R.id.BtnFalse)
        Btn_next = findViewById(R.id.Btn_next)


        // Display the first question
        displayQuestion()

        // Set click listeners for answer buttons
        BtnTrue.setOnClickListener { checkAnswer(true) }
        BtnFalse.setOnClickListener { checkAnswer(false) }

        // Set click listener for next button
        Btn_next.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                feedbackTextView.text = ""
                BtnTrue.isEnabled = true
                BtnFalse.isEnabled = true
                Btn_next.isEnabled = false
            } else {
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)  // FIXED: 'Intent' should be lowercase 'intent'
                startActivity(intent)
                finish()
            }
        }

        Btn_next.isEnabled = false
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            feedbackTextView.setTextColor(Color.GREEN)
            score++
        } else {
            feedbackTextView.text = "Incorrect!"
            feedbackTextView.setTextColor(Color.RED)
        }

        BtnTrue.isEnabled = false
        BtnFalse.isEnabled = false
        Btn_next.isEnabled = true
    }
}
