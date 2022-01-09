package com.kosy.unitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.kosy.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var ans: Float = 0.0F


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    val float = ("" + s).toFloat()
                    ans = float * 2.5F
                    binding.textView.text = "$ans Li"
                } catch (exception: NumberFormatException) {
                    binding.textView.text = s
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        setContentView(binding.root)


    }
}