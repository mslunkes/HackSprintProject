package com.example.fintrack

import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


// adaptação entre data class e um layout (expenses_list)
class ExpensesAdapter:
    ListAdapter<Expenses, ExpensesAdapter.ExpensesViewHolder>(ExpensesViewHolder.ExpenseDiffUtils) {

        //criar um viewholder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        TODO("Not yet implemented")
    }

        //bind = atrelar o dado com a UI views
        override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        TODO("Not yet implemented")
        }
    }

    //view que segura os  dados
    class ExpensesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvType = view.findViewById<TextureView>(R.id.tv_type)
        private val tvPrice = view.findViewById<TextureView>(R.id.tv_price)

        fun bind(expenses: Expenses) {
            tvType.text = expenses.type
            tvPrice.text = expenses.price
        }

    }
    class ExpenseDiffUtils : DiffUtil.ItemCallback<Expenses>() {
        override fun areItemsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
            return oldItem.type == newItem.type
        }
    }