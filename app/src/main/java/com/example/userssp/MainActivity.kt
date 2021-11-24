package com.example.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.auth.User

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearlayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUsers())
        linearlayoutManager = LinearLayoutManager(this )

        binding.recyclerView.apply {
            var layoutManager = linearlayoutManager
            var adapter = userAdapter
        }

    }
    private fun getUsers(): MutableList<User>{
        val users = mutableListOf<User>()

        val Josue = User(1 , "josue", "Recoba")
        val Alan = User(2 , "Alan", "Juarez")
        val Uriel = User(3 , "Uriel", "Lopez")

        users.add(Josue)
        users.add(Alan)
        users.add.(Uriel)


        return users
    }
}