package com.example.campsite_commander

import android.os.Bundle
import android.widget.Button
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
import com.example.campsite_commander.ui.theme.Campsite_CommanderTheme

class MainActivity : ComponentActivity() {

    private val items = arrayOf("Tent", "Marshmellows", "Flashlight", "")

    private val categories = arrayOf("Shelter", "Food", "Safety", "")

    private val quantities = arrayOf("1", "3", "2", "")

    private val comments = arrayOf("4-person waterproof", "For S'mores (Mega Size)", "Check Batteries", "")


    private var feedbackList = mutableListOf<String>()
    private var requirements = 4
    private var quantityStart = 6
    private var total = Array(7) {""}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        showWelcomeScreen()
    }

    //function for the splash screen of the application
    private fun showWelcomeScreen() {
        setContentView(R.layout.splash_screen)
        //start button of the app to go to the next screen
        val startButton = findViewById<Button>(R.id.btnStart)
        //the exit splash button is to exit the app completely at the start of the program
        val exitSplashButton = findViewById<Button>(R.id.btnExitSplash)
        startButton.setOnClickListener {
            feedbackList.clear()
            showMainScreen()
        }
        exitSplashButton.setOnClickListener {
            finish()
        }
    }

    //function for the main screen of the application
    private fun showMainScreen() {
        setContentView(R.layout.main_screen)

        //variable declarations of the buttons on the main screen
        val btnAdd = findViewById<Button>(R.id.btnAdd_Gear)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay_items)
        val btnNext = findViewById<Button>(R.id.btnNext_screen)

        //variable declarations of the editTexts and textViews of the app
        val feedbackText = findViewById<TextView>(R.id.txtResponse)
        val earlyDetails = findViewById<TextView>(R.id.txtEarly_Details)

        btnAdd.setOnClickListener {

        }

        btnDisplay.setOnClickListener {

        }

        btnNext.setOnClickListener {
            requirements++
            if (requirements < items.size || requirements < quantities.size || requirements < categories.size) {
                showMainScreen()
            } else {
                showDetailsScreen()
            }
        }
    }
    //function for the details screen of the application
    private fun showDetailsScreen(){
        //linking the details screen to the function
        setContentView(R.layout.detailed_view_screen)
        //declarations for the details screen
        val fullDetails = findViewById<TextView>(R.id.txtDetails)
        val reviewButton = findViewById<Button>(R.id.btnDetails)
        val btnBack = findViewById<Button>(R.id.btnBack_to_main)

        fullDetails.text = "you have added new things to your inventory"

        reviewButton.setOnClickListener {
            var display = ""

            for (i in items.indices) {

                display += "${items[i]}\n"
                display += "Category: ${categories[i]}\n"
                display += "Quantity: ${quantities[i]}\n"
                display += "Comments: ${comments[i]}\n"
            }

        }

        btnBack.setOnClickListener {

        }



    }


}

