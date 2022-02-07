package com.example.apptask



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.apptask.ADAPTER.MyViewHolder

internal class ADAPTER(private var itemlist:List<String> ):RecyclerView.Adapter<ADAPTER.MyViewHolder>() {
   internal inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
var itemTextView: TextView =view.findViewById(R.id.textView2)
        }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
val itemView=LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
    return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
    val item=itemlist[position]
        holder.itemTextView.text=item
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

}