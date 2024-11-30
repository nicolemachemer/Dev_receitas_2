package com.example.receitas_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.useID)
        pass = findViewById(R.id.Password)
        loginButton = findViewById(R.id.button)

        loginButton.setOnClickListener {
            if (user.text.toString().equals("Nicole") && pass.text.toString().equals("1234"))
                Toast.makeText(this, "Foi!", Toast.LENGTH_LONG).show()
        }
    }
}

