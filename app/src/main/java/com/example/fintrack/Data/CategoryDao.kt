package com.example.fintrack.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query


@Dao
interface CategoryDao {


    @Delete
    fun delete(categoryEntity: CategoryEntity)
    @Query("Select * From categoryentity")
    fun getAllCategories(): List<CategoryEntity>
}