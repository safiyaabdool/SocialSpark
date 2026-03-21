package com.example.project1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnSuggest.setOnClickListener {
            val timeInput = editTextTime.text.toString().trim().lowercase()

            if (timeInput.isEmpty()){
                textResult.text="Please enter a time of day."
                return@setOnClickListener
            }

            val suggestion = when(timeInput){
                "morning"->"Send a 'Good morning' text to someone you'd like to reconnect with"
                "mid-morning"->"Reach out to 3 people 'Hey, how have you been?'"
                "afternoon"->"Send a friend a 'I was thinking, I really appreciate how you always...' message"
                "snack time"->"Send a 'This reminded me of you' message (attach meme, song or video)"
                "dinner"->"Call a friend and acknowledge something important:'Hey, how did that thing you were nervous about go?'"
                "night","after dinner"->"like and leave thoughtful comments on friend's posts"

                else->"Invalid input. Try:Morning,Mid-morning,Afternoon,Snack Time,Dinner,Night."
            }

            textResult.text=suggestion
        }

        btnReset.setOnClickListener {
            editTextTime.text.clear()
            textResult.text="Suggestion will appear here"
        }

    }
}
