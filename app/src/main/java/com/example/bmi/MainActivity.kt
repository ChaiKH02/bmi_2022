package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //infalte = displayt the ui
        //root = top of a tree struture -> layout
        setContentView(binding.root) //local variabel


        binding.buttonReset.setOnClickListener{}
        binding.buttonCalculate.setOnClickListener {
            if (binding.editTextHeight.text.isEmpty()){
                binding .editTextHeight.setError(
                    getString(R.string.value_rquired)
                )
                return@setOnClickListener
            }
            val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            val bmi = weight / (height/100).pow(2)

            if (bmi < 18.5){
                binding.textView2.text =
                    String.format("%s : %.2f (%s)",
                getString(R.string.app_name),
                bmi,
                getString(R.string.underweight))
                binding.imageView.setImageResource(R.drawable.under)
            }
        }
    }
}