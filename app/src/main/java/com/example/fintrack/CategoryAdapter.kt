package com.example.fintrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.Data.CategoryEntity
import com.example.fintrack.Data.ExpensesEntity

class CategoryAdapter :
    ListAdapter<CategoryEntity, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtils) {


    private lateinit var onClick: (CategoryEntity) -> Unit

    private lateinit var onLongClick: (CategoryEntity) -> Unit

    fun setOnClickListener(onClick: (CategoryEntity) -> Unit) {
        this.onClick = onClick
    }

    fun setOnLongClickListener(onLongClick: (CategoryEntity) -> Unit) {
        this.onLongClick = onLongClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category, onClick, onLongClick)
    }

    class CategoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val tvCategory = view.findViewById<TextView>(R.id.tv_categoryList)

        fun bind(
            category: CategoryEntity,
            onClick: (CategoryEntity) -> Unit,
            onLongClickListener: (CategoryEntity) -> Unit
        ) {
            tvCategory.text = category.name
            tvCategory.isSelected = category.isSelected


            view.setOnClickListener {
                onClick.invoke(category)
            }

            view.setOnLongClickListener {
                onLongClickListener.invoke(category)
                true
            }
        }
    }

    companion object CategoryDiffUtils : DiffUtil.ItemCallback<CategoryEntity>() {
        override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
