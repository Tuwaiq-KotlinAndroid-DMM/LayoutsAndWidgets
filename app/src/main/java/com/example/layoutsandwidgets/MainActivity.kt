package com.example.layoutsandwidgets

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.add_button)
        var counter: Int = 1
        addButton.setOnClickListener(){

            // View Group -- starts here

            val layout:LinearLayout = LinearLayout(this)

            layout.setLayoutParams(
                LayoutParams(
                    LayoutParams.WRAP_CONTENT, // for layout_Width
                    LayoutParams.WRAP_CONTENT // For layout_height
                )
            )
            layout.setOrientation(LinearLayout.HORIZONTAL)

            val parentLayout: LinearLayout = findViewById(R.id.linear_layout)
            parentLayout.addView(layout)

            // View Group -- ends here


            // TextView (view) - starts here
                val text_view:TextView = TextView(this)

            var textViewParams: LayoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT, // for layout_width
                LayoutParams.WRAP_CONTENT // for layout_height
            )
            text_view.layoutParams = textViewParams

            // setting text size
            text_view.setTextSize(20f)

            // Setting color
            text_view.setTextColor(Color.MAGENTA)

            // Setting fonts
            text_view.setTypeface(Typeface.MONOSPACE)

            // Setting nackground color
            text_view.setBackgroundColor(Color.LTGRAY)

            // Setting padding
            text_view.setPadding(10,10,10,10)

            // Add the text to text_view
            text_view.text = "TextView No. $counter"

            text_view.setOnClickListener(){
                Toast.makeText(this, text_view.text, Toast.LENGTH_SHORT).show()
            }

            // Adding text_view to parent layout
            layout.addView(text_view)

            // Increament the counter everytime.
            counter++
            // TextView (view) - ends here


            // Button (View) - starts here
            val delete_button: Button = Button(this)

            var deleteLayoutParams: LayoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
            delete_button.layoutParams = deleteLayoutParams

            // Setting a background for button
            delete_button.setBackgroundColor(Color.WHITE)

            // Setting a Text
            delete_button.text = "Delete"

            delete_button.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_baseline_delete_forever_24, 0, 0, 0
            )

            delete_button.setOnClickListener(){
//                (text_view.getParent() as LinearLayout).removeView(it)
//                (text_view.getParent() as LinearLayout).removeView(text_view)

                (text_view.getParent() as LinearLayout).removeAllViews()
            }

            layout.addView(delete_button)

            // Button (View) - ends here



        }
    }
}