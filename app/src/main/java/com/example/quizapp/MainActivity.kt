package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //UI elements
        val welcomemessage = findViewById<TextView>(R.id.Welcome_text)
        val appDescription = findViewById<TextView>(R.id.Desc)
        val startButton = findViewById<Button>(R.id.btnstart2)
        val exitButton = findViewById<Button>(R.id.btnExit2)

        //welcome message
        welcomemessage.text = "Welcome to the quiz game!"
        appDescription.text = "come and test your knowledge today with these fun short questions :)"

        //set click listener for start button
        startButton.setOnClickListener {
            val intent = Intent(this, quiz::class.java)
            startActivity(intent)
        }



        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }

    private fun intent(mainActivity: MainActivity, java: Any): Intent? {
        TODO("Not yet implemented")
    }
}