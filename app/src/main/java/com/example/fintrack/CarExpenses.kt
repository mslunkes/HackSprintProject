package com.example.fintrack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.Data.Expenses

class CarExpenses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_expenses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvExpenses = findViewById<RecyclerView>(R.id.rv_expenses)
        val adapter = ExpensesAdapter()
        rvExpenses.adapter = adapter
        rvExpenses.layoutManager = LinearLayoutManager(this)
        adapter.submitList(expenses)
    }
}

private val expenses = listOf(
    Expenses(
        "Fuel",
        "$20.00"
    ),
    Expenses(
        "Battery",
        "$300.00"
    ),
    Expenses(
        "Engine Oil",
        "$30.00"
    ),
    Expenses(
        "Maintenance",
        "$90.00"
    )
)