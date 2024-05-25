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

        val expenseAdapter = ExpensesAdapter()
        val categoryAdapter = CategoryAdapter()


        binding.recicleView.adapter = expenseAdapter
        binding.recicleViewCategory.adapter = categoryAdapter
        binding.recicleView.layoutManager = LinearLayoutManager(this)
        binding.recicleViewCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.expensesEntity.collect{
                    expenseAdapter.submitList(it)
                }

            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.categoryEntity.collect{
                    categoryAdapter.submitList(it)
                }

            }
        }




        expenseAdapter.setOnClickListener { expense->
            openExpenseDetail()

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