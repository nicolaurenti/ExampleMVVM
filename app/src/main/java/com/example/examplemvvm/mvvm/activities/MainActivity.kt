package com.example.examplemvvm.mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examplemvvm.R
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.mvvm.viewmodel.RandomViewModel
import com.example.examplemvvm.mvvm.viewmodel.states.RandomStates
import com.example.examplemvvm.mvvm.viewmodel.states.RandomData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = ViewModelProvider(this)[RandomViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel?.getValue()?.observe(this, Observer { updateUI(it) })
    }

    private fun updateUI(randomData: RandomData) {
        when (randomData.state) {
            RandomStates.RANDOM -> {
                binding.valueText.text = randomData.value.toString()
                showToast()
            }
            else -> binding.valueText.text = "Inicio"
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Valor Generado", Toast.LENGTH_SHORT).show()
    }
}
