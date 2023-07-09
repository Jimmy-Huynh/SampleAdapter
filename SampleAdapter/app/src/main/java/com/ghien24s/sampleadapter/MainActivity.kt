package com.ghien24s.sampleadapter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghien24s.sampleadapter.adapter.CategoryAdapter
import com.ghien24s.sampleadapter.databinding.ActivityMainBinding
import com.ghien24s.sampleadapter.model.Category

class MainActivity : AppCompatActivity(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val cate1 = Category("0001", "Category 1", "Tag 1", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate2 = Category("0002", "Category 2", "Tag 2", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate3 = Category("0003", "Category 3", "Tag 3", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate4 = Category("0004", "Category 4", "Tag 4", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate5 = Category("0005", "Category 5", "Tag 5", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")

        var categories: List<Category> = listOf(cate1, cate2, cate3, cate4, cate5)


        categoryAdapter = CategoryAdapter(applicationContext, this)

        binding.apply {
            rcCategory.apply {
                adapter = categoryAdapter
                layoutManager = LinearLayoutManager(applicationContext)
//                layoutManager =
//                    GridLayoutManager(applicationContext, 1, GridLayoutManager.HORIZONTAL, false)
            }
        }
        categoryAdapter.submitList(categories)
    }

    override fun onItemClick(category: Category) {
        Log.d("Jimmy", category.name!!)
    }


}