package com.ukadovlad21.jokeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as JokeApp).viewModel

        val button = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<View>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.textView)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }
        viewModel.init(object : TextCallback {
            override fun provideText(text: String) = runOnUiThread(){
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = text
            }

        })

    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}