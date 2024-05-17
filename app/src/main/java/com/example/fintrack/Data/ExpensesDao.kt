package com.example.fintrack.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert


@Dao
interface ExpensesDao {

    @Query ("Select * From expensesentity")
    fun getAllExpenses(): List<ExpensesEntity>
    @Query ("Select * From expensesentity where category is :categoryName")
    fun getAllByCategoryName(categoryName:String): List<ExpensesEntity>
    @Insert(onConflict = OnConflictStrategy. REPLACE)
    fun insertAll(expensesEntities: List<ExpensesEntity>)
    @Upsert()
    fun upsert(expensesEntity: ExpensesEntity)
    @Update
    fun update(expenseEntity: ExpensesEntity)
    @Delete
    fun delete(expenseEntity: ExpensesEntity)
    @Delete
    fun deleteAll(expenseEntity: List<ExpensesEntity>)
    @Query("delete from expensesentity WHERE id = :id")
    suspend fun deleteById(id: Int)
}