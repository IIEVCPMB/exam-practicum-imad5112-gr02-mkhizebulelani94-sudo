package com.example.campsite_commander

import android.os.Bundle
import android.telephony.ims.SipDetails
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
import kotlin.text.get

class MainActivity : ComponentActivity() {

    private lateinit var splashLayout: LinearLayout
    private lateinit var mainLayout: ScrollView
    private lateinit var detailsLayout: ScrollView

    private lateinit var txtDetails: TextView
    private lateinit var txtTotalItem: TextView

    private lateinit var editItem: EditText
    private lateinit var editCategory: EditText
    private lateinit var editQuantity: EditText

    private lateinit var spinnerItems: Spinner

    private val items = arrayOf("Tent", "Marshmellows", "Flashlight", "")

    private val categories = arrayOf("Shelter", "Food", "Safety", "")

    private val quantities = arrayOf("1", "3", "2", "")

    private val comments = arrayOf("4-person waterproof", "For S'mores (Mega Size)", "Check Batteries", "")


    private var feedbackList = mutableListOf<String>()
    private var requirements = 4
    private var quantityStart = 6
    private var total = Array(6) {""}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        splashLayout = findViewById(R.id.splashLayout)
        mainLayout = findViewById(R.id.mainLayout)
        detailsLayout = findViewById(R.id.detailsLayout)

        txtDetails = findViewById(R.id.txtDetails)
        txtTotalItem = findViewById(R.id.txtTotalItem)

        editItem = findViewById(R.id.editItem)
        editCategory = findViewById(R.id.editCategory)
        editQuantity = findViewById(R.id.editQuantity)

        spinnerItems = findViewById(R.id.spinnerItems)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        spinnerItems.adapter = adapter

        //start button of the app to go to the next screen
        val startButton = findViewById<Button>(R.id.btnStart)
        //the exit splash button is to exit the app completely at the start of the program
        val exitSplashButton = findViewById<Button>(R.id.btnExitSplash)

        //variable declarations of the buttons on the main screen
        val btnAdd = findViewById<Button>(R.id.btnAdd_Gear)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay_items)
        val btnNext = findViewById<Button>(R.id.btnNext_screen)
        val btnBack = findViewById<Button>(R.id.btnBack_to_main)

        val feedbackText = findViewById<TextView>(R.id.txtResponse)
        val earlyDetails = findViewById<TextView>(R.id.txtEarly_Details)


        startButton.setOnClickListener {
            feedbackList.clear()
        }
        exitSplashButton.setOnClickListener {
            finish()
        }
        btnAdd.setOnClickListener {
            if (editItem.text.isEmpty() || editQuantity.text.isEmpty() || editCategory.text.isEmpty()) {
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show()
            } else {

                val index = spinnerItems.selectedItemPosition

                editItem[index] = editItem.text.toString()
                editCategory[index] = editCategory.text.toString()
                editQuantity[index] = editQuantity.text.toString().toInt()

                Toast.makeText(this, "Data is successfully added", Toast.LENGTH_LONG).show()

                editQuantity.text.clear()
                editCategory.text.clear()
                editItem.text.clear()

            }
        }

        btnDisplay.setOnClickListener {
            var display = ""

            for (i in items.indices) {

                display += "${items[i]}\n"
                display += "Category: ${categories[i]}\n"
                display += "Quantity: ${quantities[i]}\n"
                display += "Comments: ${comments[i]}\n"
            }

        }
        btnNext.setOnClickListener {

        }
        btnBack.setOnClickListener {
            detailsLayout.visibility = View.GONE
            mainLayout.visibility = View.GONE

        }


    }



    }






