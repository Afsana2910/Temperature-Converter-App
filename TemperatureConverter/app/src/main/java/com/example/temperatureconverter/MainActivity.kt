package com.example.temperatureconverter

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    private val TAG = "MyActivity"
    var isModeCelsius: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val convert = findViewById<Button>(R.id.button)
        val modeButton = findViewById<Button>(R.id.button2)
        val editxt = findViewById<EditText>(R.id.editText)
        val showResultTextView = findViewById<TextView>(R.id.textView2)
        modeButton.setOnClickListener {
            isModeCelsius=!isModeCelsius
            if(isModeCelsius)
            {
                val heading = findViewById<TextView>(R.id.textView).apply {
                    val caption = "Farenheit to Celcius"
                    text = caption
                }
            }
            else
            {
                val newheading = findViewById<TextView>(R.id.textView).apply {
                    val newcaption = "Celcius to Farenheit"
                    text = newcaption
                }
            }
        }
        convert.setOnClickListener {
            val msg = editxt.text.toString()
            if(editText.length()==0)
            {
                editText.setError("Enter a Value")
            }
            else
            {
                if (isModeCelsius) {
                        val far = msg.toDouble()
                        val cel = (far - 32) * 0.5555555556
                        showResultTextView.text = "Result: " + cel.toString()

                } else {

                        val cel = msg.toDouble()
                        val far = (cel * 1.8) + 32
                        showResultTextView.text = "Result: " + far.toString()

                }
            }
        }
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG,"App is Paused")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"App is Resumed")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"App is Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"App is Destroyed")
    }

}
