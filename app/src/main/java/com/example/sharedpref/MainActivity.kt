package com.example.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private var num:Int = 0


class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onCreate()
    }

    private fun onCreate() {
        val preferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        num = preferences.getInt("count", num)

        textView = findViewById(R.id.textViewCount)
        val count = num+1
        num = count
        editor.putInt("count", num)
        editor.apply()
        textView.text = "Количество запусков: " + preferences.getInt("count", num).toString()

    }
}