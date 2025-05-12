package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.review_TextView)
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Fetch questions and answers
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append("Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewTextView.text = reviewText.toString()
        } else {
            reviewTextView.text = "Error loading review data."
        }

        btnRestart.setOnClickListener {
            startActivity(Intent(this, quiz::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}
