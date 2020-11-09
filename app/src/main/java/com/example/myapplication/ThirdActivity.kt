package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val backToMainBtn: Button = findViewById(R.id.button_back_to_main)
        val backBtn: Button = findViewById(R.id.button_third_back)

        backToMainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }

        backBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}