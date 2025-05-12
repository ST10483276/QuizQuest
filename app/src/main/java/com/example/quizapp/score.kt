package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.libraries.places.api.model.Review
import kotlin.system.exitProcess

class score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.Score_textView)
        val feedbackTextView = findViewById<TextView>(R.id.Feedback_textView)
        val reviewButton = findViewById<Button>(R.id.Review_button)
        val exitButton = findViewById<Button>(R.id.exit_button)

        val score = intent.getIntExtra("score",0)
        scoreTextView.text = "Your score: $score/5"

        val feedback = if (score >= 3) {
            "GOOD JOB!"
        } else {
            "Keep practicing, you are almost there!"
        }
        feedbackTextView.text = feedback

        reviewButton.setOnClickListener {
            //start reviewActivity and pass questions and answers
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", quiz.questions)
            intent.putExtra("answers", quiz.answers)
            startActivity(intent)
        }


        exitButton.setOnClickListener{
            finishAffinity() //terminate the app
            exitProcess(0)
        }

    }
}