package com.example.fintrack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.recicleView.adapter = adapter
        binding.recicleView.layoutManager = LinearLayoutManager(this)



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.expensesEntity.collect{
                    adapter.submitList(it)


                }

            }

        }


       // adapter.submitList()
        adapter.setOnClickListener { expense->

        }

        binding.floatActionButton.setOnClickListener{
            openExpenseDetail()

        }





      


    }

    private fun openExpenseDetail(){
        val intent = ExpenseDetail.start(this,null)
        startActivity(intent)
    }




}