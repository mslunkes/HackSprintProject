package com.example.fintrack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

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

        // criar data class
        // criar lista de gastos do tipo data class
        // criar adapter
        // settar adapter
        // linear layout manager
        val rvExpenses: RecyclerView = findViewById(R.id.rv_expenses)
    }
}

    private val expenses = listOf(
    Expenses(
        "Fuel"
        "$20.00"
    ),
    Expenses(
        "Battery"
        "$300.00"
    ),
    Expenses(
        "Engine Oil"
        "$30.00"
    ),
    Expenses(
        "Maintenance"
        "$90.00"
    ),
)
    }
}