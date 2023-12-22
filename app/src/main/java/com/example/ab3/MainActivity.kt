package com.example.ab3

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    private lateinit var first:LinearLayout
    private lateinit var second:LinearLayout
    private lateinit var line:String
    private lateinit var color:String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first=findViewById(R.id.first)
        second=findViewById(R.id.second)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            line= intent?.getStringExtra("selectedMode").toString()
            color = intent?.getStringExtra("selectedColor").toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    private fun clearColors() {
        first.setBackgroundColor(Color.WHITE)
        second.setBackgroundColor(Color.WHITE)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        var id:Int=item.itemId

        when(id)
        {
            R.id.action_input->{
                var intent=Intent(this,InputActivity::class.java)
                startForResult.launch(intent)
                return true
            }
            R.id.action_change->{
                if(line.equals("Up")) {
                    if (color.equals("red")) {
                        first.setBackgroundColor(Color.RED);
                    }
                    if (color.equals("green")) {
                        first.setBackgroundColor(Color.GREEN);
                    }
                    if (color.equals("blue")) {
                        first.setBackgroundColor(Color.BLUE);
                    }
                }
                if(line.equals("Down") ){
                    if (color.equals("red")) {
                        second.setBackgroundColor(Color.RED);
                    }
                    if (color.equals("green")) {
                        second.setBackgroundColor(Color.GREEN);
                    }
                    if (color.equals("blue")) {
                        second.setBackgroundColor(Color.BLUE);
                    }
                }
               return true
            }
            R.id.action_clear->
            {
                clearColors()
                return true
            }
            else->
                return super.onOptionsItemSelected(item);
        }
    }
}