package com.example.apptask

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        public val itemlist=ArrayList<String>()
      public val itemplisricet=ArrayList<String>()
        internal lateinit var customAdapter:ADAPTER

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resyclview)

        val addproductt=findViewById<Button>(R.id.addproduct)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerView)
        itemlist.add(addproduct.itemname)
        itemplisricet.add(addproduct.itemprice.toString())
        //itemlist.addAll(resources.getStringArray(R.array.names_item))
        customAdapter =ADAPTER(
            itemlist,
            itemplisricet
        )
        val layoutManager= GridLayoutManager(this,2)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=customAdapter

            addproductt.setOnClickListener {
                val Intent= Intent(this,addproduct::class.java)
                startActivity(Intent)
                
            }





    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext,"DISABLED BACK PRESS",Toast.LENGTH_SHORT).show()
    }

}