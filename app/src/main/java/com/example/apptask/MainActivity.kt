package com.example.apptask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val itemlist=ArrayList<String>()

    private lateinit var customAdapter:ADAPTER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resyclview)
        itemlist.addAll(resources.getStringArray(R.array.names_item))
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        customAdapter=ADAPTER(itemlist)
    val layoutManager=LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=customAdapter
    }
}