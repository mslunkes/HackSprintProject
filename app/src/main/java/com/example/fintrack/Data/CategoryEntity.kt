package com.example.fintrack.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity(
    @PrimaryKey
    @ColumnInfo("key")
    val name:String,
    @ColumnInfo("is_selected")
    val isSelected:Boolean,

)
