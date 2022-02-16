package com.example.apptask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.text.trim as trim1

class addproduct : AppCompatActivity() {
    companion object{public  var  itemname=""
        public var  itemprice=""}






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addpoduct)

        val add=findViewById<Button>(R.id.add)


        add.setOnClickListener {
           val  name_product=findViewById<EditText>(R.id.NAMEPRODUCT).text.toString().trim1()
            val price_product=findViewById<EditText>(R.id.PRICEPRODUCT).text
            val  QUANTITY_product=findViewById<EditText>(R.id.QUANTITAY).text
                if(name_product.isEmpty()){
                    findViewById<EditText>(R.id.NAMEPRODUCT).error="NAME    REQUIRED"
                    findViewById<EditText>(R.id.NAMEPRODUCT).requestFocus()
                    Toast.makeText(applicationContext,"NAME REQUIRED", Toast.LENGTH_SHORT).show()

                    return@setOnClickListener

                }
            if(price_product.isEmpty()){
                findViewById<EditText>(R.id.PRICEPRODUCT).error="PRICE    REQUIRED"
                findViewById<EditText>(R.id.PRICEPRODUCT).requestFocus()
                Toast.makeText(applicationContext,"PRICE REQUIRED", Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
            if(QUANTITY_product.isEmpty()){
                findViewById<EditText>(R.id.QUANTITAY).error="QUANTITY    REQUIRED"
                findViewById<EditText>(R.id.QUANTITAY).requestFocus()
                Toast.makeText(applicationContext,"QUANTITY REQUIRED", Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
            if(QUANTITY_product.isDigitsOnly()){

            }else{
                findViewById<EditText>(R.id.QUANTITAY).error="mustbedigit"
                findViewById<EditText>(R.id.QUANTITAY).requestFocus()
                Toast.makeText(applicationContext,"mustbedigit", Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
            if(price_product.isDigitsOnly()){

            }else{
                findViewById<EditText>(R.id.QUANTITAY).error="mustbedigit"
                findViewById<EditText>(R.id.QUANTITAY).requestFocus()
                Toast.makeText(applicationContext,"mustbedigit", Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
            retrofit.instance.creatproduct(
                name_product,price_product,QUANTITY_product).enqueue(object :Callback<defoultresponce>{
                override fun onResponse(call: Call<defoultresponce>,response: Response<defoultresponce>) {
                    Toast.makeText(applicationContext,name_product,Toast.LENGTH_LONG).show()

                    itemname=name_product
                    itemprice=price_product.toString()



                }

                override fun onFailure(call: Call<defoultresponce>, t: Throwable) {
                    Toast.makeText(applicationContext,"notdone",Toast.LENGTH_LONG).show()
                }

            })

        }

    }
    override fun onBackPressed() {
        Toast.makeText(applicationContext,"DISABLED BACK PRESS",Toast.LENGTH_SHORT).show()
    }
}