package com.example.fintrack.Data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["key"],
            childColumns = ["category"]
        )
    ]
)
class ExpensesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val price: String,
    val category:String
)



