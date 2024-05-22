package com.example.fintrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.Data.Expenses

class ExpensesAdapter(private val openExpenseDetail: (expenses: Expenses) -> Unit):
    ListAdapter
<Expenses, ExpensesAdapter.ExpensesViewHolder>(ExpenseDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val view = LayoutInflater.
        from(parent.context).inflate(R.layout.expenses_list, parent, false)
        return  ExpensesViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }


    class ExpensesViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val tvType = view.findViewById<TextView>(R.id.tv_title)
        private val tvPrice = view.findViewById<TextView>(R.id.tv_price)
        fun bind(expenses: Expenses) {
            tvType.text = expenses.title
            tvPrice.text = expenses.price
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

       
