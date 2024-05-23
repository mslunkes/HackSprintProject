package com.example.fintrack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.fintrack.Data.ExpensesViewModel
import com.example.fintrack.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: ExpensesViewModel


  private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val factory = ExpensesViewModel.getVMFactory(application)
        viewModel = ViewModelProvider(this, factory)[ExpensesViewModel::class.java]

        val adapter = ExpensesAdapter()
        val rvList = binding.recicleView

        rvList.adapter = adapter

        lifecycleScope.launch {
            viewModel.
        }


       // adapter.submitList()
        adapter.setOnClickListener { expense->

        }

      


    }




}