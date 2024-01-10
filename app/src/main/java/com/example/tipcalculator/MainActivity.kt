package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*




class MainActivity : AppCompatActivity() {
    private lateinit var editTextBillAmount: EditText
    private lateinit var radioGroupTipPercentage: RadioGroup
    private lateinit var btnCalculate: Button
    private lateinit var textViewTipAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextBillAmount = findViewById(R.id.editTextBillAmount)
        radioGroupTipPercentage = findViewById(R.id.radioGroupTipPercentage)
        btnCalculate = findViewById(R.id.btnCalculate)
        textViewTipAmount = findViewById(R.id.textViewTipAmount)

        btnCalculate.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val selectedRadioButtonId = radioGroupTipPercentage.checkedRadioButtonId

        val tipPercentage: Double = when (selectedRadioButtonId) {
            R.id.radio10Percent -> 0.10
            R.id.radio20Percent -> 0.20
            R.id.radio30Percent -> 0.30
            else -> 0.0
        }

        val billAmount = editTextBillAmount.text.toString().toDoubleOrNull() ?: 0.0
        val tipAmount = billAmount * tipPercentage

        textViewTipAmount.text = "Tip Amount: LKR" + String.format("%.2f", tipAmount)
    }
}

