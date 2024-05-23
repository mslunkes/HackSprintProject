package com.example.fintrack

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.Data.Expenses
import com.example.fintrack.Data.ExpensesApplication
import com.example.fintrack.Data.ExpensesViewModel

class ExpensesAdapter():
    ListAdapter
<Expenses, ExpensesAdapter.ExpensesViewHolder>(ExpenseDiffUtils()) {

    private lateinit var onClickListener:(Expenses)-> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val view = LayoutInflater.
        from(parent.context).inflate(R.layout.expenses_list, parent, false)
        return  ExpensesViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }

    fun setOnClickListener(onClick:(Expenses)-> Unit){
        onClickListener= onClick

    }


    class ExpensesViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val tvType = view.findViewById<TextView>(R.id.tv_title)
        private val tvPrice = view.findViewById<TextView>(R.id.tv_price)
        fun bind(expenses: Expenses, onClick:(Expenses)-> Unit) {
            tvType.text = expenses.title
            tvPrice.text = expenses.price

            view.setOnClickListener { onClick.invoke(expenses) }
        }


    }
    class ExpenseDiffUtils : DiffUtil.ItemCallback<Expenses>() {
        override fun areItemsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
            return oldItem.title == newItem.title
        }
    }
}

       
