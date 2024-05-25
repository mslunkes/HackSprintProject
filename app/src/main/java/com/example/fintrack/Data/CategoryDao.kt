package com.example.fintrack.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {


    @Delete
    fun delete(categoryEntity: CategoryEntity)

    @Query("Select * From expensesentity")
    fun getAllExpenses(): Flow<List<ExpensesEntity>>
    @Upsert()
    suspend fun upsert(categoryEntity: CategoryEntity)
    @Query("delete from categoryentity WHERE `key`=:id")
    suspend fun deleteById(id: Int)

    @Query ("Select * From expensesentity where category is :categoryName")
    fun getAllByCategoryName(categoryName:String): List<ExpensesEntity>

    @Query("Select * From categoryentity")
    fun getAllCategories(): Flow<List<CategoryEntity>>
}