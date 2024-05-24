package com.example.fintrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.Data.ExpensesEntity

class ExpensesAdapter():
    ListAdapter
<ExpensesEntity, ExpensesAdapter.ExpensesViewHolder>(ExpenseDiffUtils()) {

    private lateinit var onClickListener:(ExpensesEntity)-> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val view = LayoutInflater.
        from(parent.context).inflate(R.layout.expenses_list, parent, false)
        return  ExpensesViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        val expense = getItem(position)
        holder.bind(expense, onClickListener)
    }

    fun setOnClickListener(onClick:(ExpensesEntity)-> Unit){
        onClickListener= onClick

    }


    class ExpensesViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val tvType = view.findViewById<TextView>(R.id.tv_title)
        private val tvPrice = view.findViewById<TextView>(R.id.tv_price)
        fun bind(expensesEntity: ExpensesEntity, onClick:(ExpensesEntity)-> Unit) {
            tvType.text = expensesEntity.title
            tvPrice.text = expensesEntity.price

            view.setOnClickListener { onClick.invoke(expensesEntity) }
        }


    }
    class ExpenseDiffUtils : DiffUtil.ItemCallback<ExpensesEntity>() {
        override fun areItemsTheSame(oldItem: ExpensesEntity, newItem: ExpensesEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ExpensesEntity, newItem: ExpensesEntity): Boolean {
            return oldItem.title == newItem.title
        }
    }
}

       
