package com.example.programmercalculator;

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    val obj=ConvertionOperations()
    private lateinit var button0: AppCompatButton
    private lateinit var button1: AppCompatButton
    private lateinit var button2: AppCompatButton
    private lateinit var button3: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button5: AppCompatButton
    private lateinit var button6: AppCompatButton
    private lateinit var button7: AppCompatButton
    private lateinit var button8: AppCompatButton
    private lateinit var button9: AppCompatButton
    private lateinit var ButtonA: AppCompatButton
    private lateinit var ButtonB: AppCompatButton
    private lateinit var ButtonC: AppCompatButton
    private lateinit var ButtonD: AppCompatButton
    private lateinit var ButtonE: AppCompatButton
    private lateinit var ButtonF: AppCompatButton
    private lateinit var textInput: TextView
    private lateinit var FromBinary: AppCompatButton
    private lateinit var FromDecimal: AppCompatButton
    private lateinit var FromOctal: AppCompatButton
    private lateinit var FromHexa: AppCompatButton
    private lateinit var DelButton: AppCompatButton
    private lateinit var ToBinary: TextView
    private lateinit var ToDecimal: TextView
    private lateinit var ToHexa: TextView
    private lateinit var ToOctal: TextView
    lateinit var ResultButtn: AppCompatButton
    lateinit var numberToConvert:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        ClickedButton()
    }

    //initialize buttons
    private fun initView() {
        button0 = findViewById(R.id.btnNum0)
        button1 = findViewById(R.id.btnNum1)
        button2 = findViewById(R.id.btnNum2)
        button3 = findViewById(R.id.btnNum3)
        button4 = findViewById(R.id.btnNum4)
        button5 = findViewById(R.id.btnNum5)
        button6 = findViewById(R.id.btnNum6)
        button7 = findViewById(R.id.btnNum7)
        button8 = findViewById(R.id.btnNum8)
        button9 = findViewById(R.id.btnNum9)
        textInput = findViewById(R.id.txt_input)
        FromBinary = findViewById(R.id.btnBin)
        FromDecimal = findViewById(R.id.btnDec)
        FromOctal = findViewById(R.id.btnOctal)
        FromHexa = findViewById(R.id.btnHex)
        ButtonA = findViewById(R.id.btnA)
        ButtonB = findViewById(R.id.btnB)
        ButtonC = findViewById(R.id.btnC)
        ButtonD = findViewById(R.id.btnD)
        ButtonE = findViewById(R.id.btnE)
        ButtonF = findViewById(R.id.btnF)
        DelButton = findViewById(R.id.btnDel)
        ToBinary = findViewById(R.id.binary_res)
        ToDecimal = findViewById(R.id.dec_res)
        ToHexa = findViewById(R.id.hex_res)
        ToOctal = findViewById(R.id.oct_res)
        ResultButtn = findViewById(R.id.btnEqual)
        numberToConvert=findViewById(R.id.txt_input)


    }

    private fun EnableButtons(vararg buttons: Button) {
        buttons.forEach { it.isEnabled = true }
    }

    private fun DisableButtons(vararg buttons: Button) {
        buttons.forEach { it.isEnabled = false }
    }

    private fun delInput() {
        textInput.text = ""
        ToBinary.text=""
        ToDecimal.text=""
        ToHexa.text=""
        ToOctal.text=""
    }

    fun onClickNumber(v: View) {
        val newDigit = (v as Button).text.toString()
        val oldDigit = numberToConvert.text.toString()
        val newTextNumber = oldDigit + newDigit
        numberToConvert.text = newTextNumber

    }
        private fun ClickedButton() {
        button0.setOnClickListener { textInput.append("0")}
        button1.setOnClickListener { textInput.append("1") }
        button2.setOnClickListener { textInput.append("2") }
        button3.setOnClickListener { textInput.append("3") }
        button4.setOnClickListener { textInput.append("4") }
        button5.setOnClickListener { textInput.append("5") }
        button6.setOnClickListener { textInput.append("6") }
        button7.setOnClickListener { textInput.append("7") }
        button8.setOnClickListener { textInput.append("8") }
        button9.setOnClickListener { textInput.append("9") }
        ButtonA.setOnClickListener { textInput.append("A") }
        ButtonB.setOnClickListener { textInput.append("B") }
        ButtonC.setOnClickListener { textInput.append("C") }
        ButtonD.setOnClickListener { textInput.append("D") }
        ButtonE.setOnClickListener { textInput.append("E") }
        ButtonF.setOnClickListener { textInput.append("F") }
        DelButton.setOnClickListener { delInput() }

        FromDecimal.setOnClickListener {
            delInput()
            DisableButtons(ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF)

            EnableButtons(
                button0, button1, button2, button3, button4,
                button5, button6, button7, button8, button9
            )
        }

        FromBinary.setOnClickListener {
            delInput()
            DisableButtons(
                ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF,
                button2, button3, button4, button5, button6, button7, button8, button9
            )

            EnableButtons(button0, button1)
        }

        FromOctal.setOnClickListener {
            delInput()
            DisableButtons(ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF, button8, button9)
            EnableButtons(button0, button1, button2, button3, button4, button5, button6, button7)
        }


        FromHexa.setOnClickListener {
            delInput()
            EnableButtons(ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF,
                button0, button1, button2, button3, button4, button5, button6,
                button7,button8, button9)
        }


        ResultButtn.setOnClickListener {
          val input = numberToConvert.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(
                    applicationContext, "please enter a valid value",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                if (FromDecimal.isClickable) {
                    ToDecimal.text = textInput.text
                    ToBinary.text = obj.ConvertFromDecimalToBinary(input)
                    ToOctal.text = obj.ConvertDecimalToOctal(input)
                    ToHexa.text = obj.ConvertDecimalToHex(input)
                }
                else if (FromBinary.isClickable) {
                    ToDecimal.text = obj.ConvertBinaryToDecimal(input)
                    ToBinary.text = textInput.text
                    ToOctal.text = obj.ConvertBinaryToOctal(input)
                    ToHexa.text = obj.ConvertBinaryToHex(input)
                } else if (FromOctal.isClickable) {
                    ToDecimal.text = obj.ConvertOctalToDecimal(input)
                    ToBinary.text = obj.ConvertOctalToBinary(input)
                    ToOctal.text = textInput.text
                    ToHexa.text =obj.ConvertOctalToHex(input)
                } else if (FromHexa.isClickable) {
                    ToDecimal.text = obj.ConvertHexToDecimal(input)
                    ToBinary.text = obj.ConvertHexToBinary(input)
                    ToOctal.text = obj.ConvertHexToOctal(input)
                    ToHexa.text = textInput.text
                }
            }


        }

    }

}