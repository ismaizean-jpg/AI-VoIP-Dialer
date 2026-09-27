package com.example.aivoipdialer

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var numberInput: EditText
    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createDialerUI()
    }

    private fun createDialerUI() {

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(24, 30, 24, 24)
        root.setBackgroundColor(Color.rgb(16, 24, 32))

        // Title
        val title = TextView(this)
        title.text = "📞 AI VoIP DIALER"
        title.textSize = 26f
        title.setTextColor(Color.WHITE)
        title.setTypeface(null, Typeface.BOLD)
        title.gravity = Gravity.CENTER
        title.setPadding(0, 10, 0, 25)

        root.addView(
            title,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // Status
        statusText = TextView(this)
        statusText.text = "● READY — OUTGOING CALLS ONLY"
        statusText.textSize = 14f
        statusText.setTextColor(Color.rgb(80, 220, 120))
        statusText.gravity = Gravity.CENTER
        statusText.setPadding(0, 0, 0, 20)

        root.addView(
            statusText,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // Number input
        numberInput = EditText(this)
        numberInput.hint = "Enter phone number"
        numberInput.textSize = 24f
        numberInput.setTextColor(Color.WHITE)
        numberInput.setHintTextColor(Color.GRAY)
        numberInput.gravity = Gravity.CENTER
        numberInput.inputType =
            android.text.InputType.TYPE_CLASS_PHONE
        numberInput.setPadding(10, 20, 10, 20)

        root.addView(
            numberInput,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        // Dial pad
        val dialPad = LinearLayout(this)
        dialPad.orientation = LinearLayout.VERTICAL
        dialPad.gravity = Gravity.CENTER
        dialPad.setPadding(0, 20, 0, 10)

        val digits = arrayOf(
            arrayOf("1", "2", "3"),
            arrayOf("4", "5", "6"),
            arrayOf("7", "8", "9"),
            arrayOf("*", "0", "#")
        )

        for (row in digits) {

            val rowLayout = LinearLayout(this)
            rowLayout.orientation = LinearLayout.HORIZONTAL
            rowLayout.gravity = Gravity.CENTER

            for (digit in row) {

                val button = Button(this)
                button.text = digit
                button.textSize = 20f
                button.setTextColor(Color.WHITE)

                button.setOnClickListener {
                    numberInput.append(digit)
                }

                rowLayout.addView(
                    button,
                    LinearLayout.LayoutParams(
                        90,
                        60
