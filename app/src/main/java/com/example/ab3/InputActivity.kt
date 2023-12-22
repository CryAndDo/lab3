package com.example.ab3
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.Button
import android.widget.CheckBox
import  android.widget.RadioGroup

class InputActivity : AppCompatActivity() {
    private lateinit var save: Button
    private lateinit var radioGroupColor: RadioGroup
    private lateinit var checkBoxDown: CheckBox
    private lateinit var checkBoxUp: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        save=findViewById(R.id.buttonSave)
        radioGroupColor=findViewById((R.id.radioGroupColor))
        checkBoxDown=findViewById(R.id.checkBoxDown)
        checkBoxUp=findViewById((R.id.checkBoxUp))
        save.setOnClickListener {
            val selectedColor:String = when (radioGroupColor.checkedRadioButtonId) {
                R.id.radioButtonRed -> "red"
                R.id.radioButtonGreen -> "green"
                R.id.radioButtonBlue -> "blue"
                else -> ""
            }

            val selectedMode = when {
                checkBoxUp.isChecked -> "Up"
                checkBoxDown.isChecked -> "Down"
                else -> "All"
            }

            val resultIntent = Intent()
            resultIntent.putExtra("selectedColor", selectedColor)
            resultIntent.putExtra("selectedMode", selectedMode)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

