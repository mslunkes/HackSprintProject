package com.example.fintrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fintrack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      

        binding.btnCar.setOnClickListener {
            val intent = Intent(this, CarExpenses::class.java)
            startActivity(intent)
        }
        binding.btnHouse.setOnClickListener {
            val intent = Intent(this, HouseExpenses::class.java)
            startActivity(intent)
        }
        binding.btnMarket.setOnClickListener {
            val intent = Intent(this, MarketExpenses::class.java)
            startActivity(intent)
        }
        binding.btnBills.setOnClickListener {
            val intent = Intent(this, BillsExpenses::class.java)
            startActivity(intent)
        }
        binding.btnLeisure.setOnClickListener {
            val intent = Intent(this, LeisureExpenses::class.java)
            startActivity(intent)
        }
        binding.btnChild.setOnClickListener {
            val intent = Intent(this, ChildExpenses::class.java)
            startActivity(intent)
        }
        binding.btnHealth.setOnClickListener {
            val intent = Intent(this, HealthExpenses::class.java)
            startActivity(intent)
        }
        binding.btnVesture.setOnClickListener {
            val intent = Intent(this, VestureExpenses::class.java)
            startActivity(intent)
        }
    }




}