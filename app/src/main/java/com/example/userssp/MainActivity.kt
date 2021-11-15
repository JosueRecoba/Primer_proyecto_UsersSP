package com.example.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearlayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(mutableListOf())
        linearlayoutManager = LinearLayoutManager(this )

        binding.recyclerView.apply {
            var layoutManager = linearlayoutManager
            var adapter = userAdapter
        }

    }
}