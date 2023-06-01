package com.example.imagesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Button = findViewById<Button>(R.id.Viewbtn)

        Button.setOnClickListener {

            intent = Intent(applicationContext,ImageScreenActivity::class.java)
            startActivity(intent)
        }

    }
}