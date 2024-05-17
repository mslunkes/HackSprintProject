package com.example.fintrack.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExpensesEntity::class, CategoryEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun expensesDao(): ExpensesDao
    abstract fun categoryDao(): CategoryDao

}