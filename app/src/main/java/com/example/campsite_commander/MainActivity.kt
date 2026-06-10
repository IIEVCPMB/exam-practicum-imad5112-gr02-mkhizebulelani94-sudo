package com.example.campsite_commander

import android.os.Bundle
import android.widget.Button
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
import com.example.campsite_commander.ui.theme.Campsite_CommanderTheme

class MainActivity : ComponentActivity() {

    private val items = arrayOf("Tent", "Marshmellows", "Flashlight", "Knife")

    private val categories = arrayOf("Shelter", "Food", "Safety", "Safety")

    private val quantities = arrayOf("1", "3", "2")






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showWelcomeScreen()
    }

    //function for the splash screen of the application
    private fun showWelcomeScreen(){
        setContentView(R.layout.splash_screen)
        val startButton = findViewById<Button>(R.id.btnStart)
        startButton.setOnClickListener {

        }

    }
}
