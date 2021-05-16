package com.youpic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.demoapp.JsonDataModel
import com.e.demoapp.R
import kotlinx.android.synthetic.main.list_layout.view.*

public class DataAdapter(private val context: Context,val data:List<JsonDataModel.History?>) : RecyclerView.Adapter<DataAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder= ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.itemView.textView.text=data.get(position)?.name+"\n Data: "+data.get(position)?.grandfathers.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}