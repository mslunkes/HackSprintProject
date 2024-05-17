package com.example.fintrack.Data

import android.app.Application
import androidx.room.Room


class ExpensesApplication : Application() {

    private lateinit var dataBase: AppDataBase
    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "Expenses-DataBase"
        ).build()
    }

    fun getAppDataBase(): AppDataBase {
        return dataBase
    }
}