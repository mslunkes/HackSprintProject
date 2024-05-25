package com.example.fintrack.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface ExpensesDao {

    @Query ("Select * From expensesentity")
    fun getAllExpenses(): Flow<List<ExpensesEntity>>
    @Insert(onConflict = OnConflictStrategy. REPLACE)
    suspend fun insert(expenseEntity: ExpensesEntity)
    @Insert(onConflict = OnConflictStrategy. REPLACE)
    suspend fun insertAll(expensesEntities: List<ExpensesEntity>)
    @Upsert()
    suspend fun upsert(expensesEntity: ExpensesEntity)
    @Update
    suspend fun update(expenseEntity: ExpensesEntity)
    @Delete
    suspend fun delete(expenseEntity: ExpensesEntity)
    @Delete
    suspend fun deleteAll(expenseEntity: List<ExpensesEntity>)
    @Query("delete from expensesentity WHERE id = :id")
    suspend fun deleteById(id: Int)
}