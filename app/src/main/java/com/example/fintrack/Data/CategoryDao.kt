package com.example.fintrack.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {


    @Delete
    fun delete(categoryEntity: CategoryEntity)

    @Query("Select * From expensesentity")
    fun getAllExpenses(): Flow<List<ExpensesEntity>>

    @Query("Select * From categoryentity")
    fun getAllCategories(): List<CategoryEntity>
}