package com.ghien24s.sampleadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghien24s.sampleadapter.R
import com.ghien24s.sampleadapter.databinding.ItemCategoryBinding
import com.ghien24s.sampleadapter.model.Category
import com.google.android.material.color.MaterialColors

class CategoryAdapter(private val context: Context, private val listener: OnItemClickListener) :
    ListAdapter<Category, CategoryAdapter.ViewHolder>(CATEGORIES_COMPARATOR) {
    var selectedTag = "All"

    inner class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val category = getItem(position)
                        listener.onItemClick(category)
                        selectedTag = category.tag!!
                        notifyDataSetChanged()
                    }
                }
            }
        }

        fun bind(category: Category) {
            binding.apply {
                if (category.tag.equals(selectedTag)) {
                    tvCategory.setTextColor(
                        MaterialColors.getColor(
                            tvCategory,
                            com.google.android.material.R.attr.colorOnPrimary
                        )
                    )
                    cvCategoryRoot.background =
                        context.getDrawable(R.drawable.rounded_border_selected)
                    root.isEnabled = false
                } else {
                    tvCategory.setTextColor(
                        MaterialColors.getColor(
                            tvCategory,
                            com.google.android.material.R.attr.colorPrimary
                        )
                    )
                    cvCategoryRoot.background =
                        context.getDrawable(R.drawable.rounded_border_search_bar)
                    root.isEnabled = true
                }
                tvCategory.text = category.name
            }
        }


    }

    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }

    companion object {
        private val CATEGORIES_COMPARATOR = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                oldItem.objectid == newItem.objectid

            override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}