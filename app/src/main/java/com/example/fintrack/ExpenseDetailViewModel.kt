package com.example.fintrack

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fintrack.Data.CategoryDao
import com.example.fintrack.Data.ExpensesApplication
import com.example.fintrack.Data.ExpensesDao
import com.example.fintrack.Data.ExpensesEntity
import com.example.fintrack.Data.ExpensesViewModel
import kotlinx.coroutines.launch

class ExpenseDetailViewModel(
    private val expensesDao: ExpensesDao,
    private val categoryDao: CategoryDao
) : ViewModel(){

    fun execute(expenseAction: ExpenseAction) {

        //ação do actiontype
        when (expenseAction.ActionType) {
            ActionType.DELETE.name -> deleteById(expenseAction.expense!!.id)
            ActionType.CREATE.name -> insertIntoDataBase(expenseAction.expense!!)
            ActionType.UPDATE.name -> updateIntoDataBase(expenseAction.expense!!)
        }
    }

    private fun insertIntoDataBase(expense: ExpensesEntity) {
        viewModelScope.launch {
            expensesDao.insert(expense)
        }
    }

    private fun updateIntoDataBase(expense: ExpensesEntity) {
        viewModelScope.launch {
            expensesDao.update(expense)
        }
    }


    private fun deleteById(id: Int) {
        viewModelScope.launch {
            expensesDao.deleteById(id)
        }
    }


    /*para utilizar viewmModel com by viewmodel e poder rotarcionar a tela sem perder o que foi
    digitado*/
    companion object {
        fun getVMFactory(application: Application): ViewModelProvider.Factory {
            val dataBaseInstance = (application as ExpensesApplication).getAppDataBase()
            val expensesDao = dataBaseInstance.expensesDao()
            val categoryDao = dataBaseInstance.categoryDao()
            val factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ExpensesViewModel(expensesDao,categoryDao) as T
                }
            }
            return factory
        }
    }
}