package com.example.fintrack

import com.example.fintrack.Data.ExpensesEntity
import java.io.Serializable

enum class ActionType {
    DELETE,
    UPDATE,
    CREATE,
}

//criando ações para implementar na task
data class ExpenseAction(
    val expense: ExpensesEntity?,
    val ActionType: String
) : Serializable