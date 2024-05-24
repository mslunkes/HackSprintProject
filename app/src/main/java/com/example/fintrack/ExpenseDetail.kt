package com.example.fintrack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.fintrack.Data.ExpensesEntity
import com.example.fintrack.Data.ExpensesViewModel
import com.example.fintrack.databinding.ExpensesDetailBinding
import com.google.android.material.snackbar.Snackbar

class ExpenseDetail : AppCompatActivity() {

    private var expense:ExpensesEntity? = null

    private lateinit var viewModel: ExpenseDetailViewModel

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ExpensesDetailBinding

    companion object {
        private const val EXPENSE_DETAIL_EXTRA = "Expense_detail_extra"

        fun start (context:Context, expense:ExpensesEntity?): Intent {
            val intent  = Intent(context,ExpenseDetail::class.java)
                .apply { putExtra(EXPENSE_DETAIL_EXTRA,expense) }
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ExpensesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        expense = intent.getSerializableExtra(EXPENSE_DETAIL_EXTRA) as ExpensesEntity?

        val factory = ExpenseDetailViewModel.getVMFactory(application)
        viewModel = ViewModelProvider(this, factory)[ExpenseDetailViewModel::class.java]

        if(expense != null){
            binding.edtExpensetitle.setText(expense!!.title)
            binding.edtPrice.setText(expense!!.price)
        }

        binding.btnDone.setOnClickListener{
            val title = binding.edtExpensetitle.text.toString()
            val price = binding.edtPrice.text.toString()
        }







    }

    private fun addOrUpdateExpense(
        id:Int,
        title:String,
        price:String,
        category:String,
        actionType: ActionType

    ){
        val newExpense = ExpensesEntity(id,title,price,category)
        executeExpenseActionAndFinish(newExpense,actionType)
    }

    private fun executeExpenseActionAndFinish(expense: ExpensesEntity, actionType: ActionType) {
        val expenseAction = ExpenseAction(expense, actionType.name)
        viewModel.execute(expenseAction)
        finish()
    }
}