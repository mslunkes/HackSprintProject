package com.example.fintrack.Data

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExpensesViewModel(
    private val expensesDao: ExpensesDao,
    private val categoryDao: CategoryDao
): ViewModel() {

    private fun deleteCategory(categoryEntity: CategoryEntity){
        viewModelScope.launch {
            val expensesToBeDeleted = expensesDao.getAllByCategoryName(categoryEntity.name)
            expensesDao.deleteAll(expensesToBeDeleted)
            categoryDao.delete(categoryEntity)
            expensesDao.getAllExpenses()
            categoryDao.getAllCategories()
        }
    }

    private fun deleteExpense(expensesEntity: ExpensesEntity){
        viewModelScope.launch {
            expensesDao.delete(expensesEntity)

        }
    }

    private fun upsertExpense(expensesEntity: ExpensesEntity){
        viewModelScope.launch {
            expensesDao.upsert(expensesEntity)
        }
    }

    private fun deleteById(id:Int){
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