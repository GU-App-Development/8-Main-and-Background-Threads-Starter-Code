package com.zybooks.fibonacci

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var outputTextView: TextView
    private lateinit var numberEditText: EditText
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputTextView = findViewById(R.id.output_text_view)
        numberEditText = findViewById(R.id.n_edit_text)
        progressBar = findViewById(R.id.progress_bar)

        findViewById<Button>(R.id.calculate_button).setOnClickListener { calculate() }
    }

    private fun fibonacci(n: Long): Long {
        return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
    }

    private fun calculate() {
        // Display progress bar
        progressBar.visibility = View.VISIBLE

        // Find the nth Fibonacci number using the given number
        val num = numberEditText.text.toString().toLong()
        val fibNumber = fibonacci(num)

        // Show the result with commas in the right place
        outputTextView.text = "Result:" +
                NumberFormat.getNumberInstance(Locale.US).format(fibNumber)

        // Hide progress bar
        progressBar.visibility = View.INVISIBLE
    }
}