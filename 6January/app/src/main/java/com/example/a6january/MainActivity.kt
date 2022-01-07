package com.example.a6january

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerBtn = findViewById<Button>(R.id.registerBtn)


        loginBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}