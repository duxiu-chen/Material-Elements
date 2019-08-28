package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.beans.ProgressBeans
import java.util.*

class ProgressAdapter(private var data: LinkedList<ProgressBeans>, private val context: Context):
        RecyclerView.Adapter<ProgressAdapter.MyViewHolder>(){

    private val TITLE = 1
    private val NORMAL = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return if (viewType == TITLE)
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_sectioned_title, parent, false))
        else
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_progress, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].isTitle)
            TITLE
        else
            NORMAL
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (getItemViewType(position) == 2){
            holder.bind(data[position])
        }else{
            holder.bind(data[position].name)
        }

    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ProgressBeans){
            itemView.findViewById<ImageView>(R.id.item_img).setImageResource(item.resId)
            itemView.findViewById<TextView>(R.id.item_name).text = item.name
            itemView.findViewById<TextView>(R.id.item_date).text = item.date
        }

        fun bind(title:String){
            itemView.findViewById<TextView>(R.id.item_title).text = title
        }

    }

    fun clear(){
        data.clear()
        notifyDataSetChanged()
    }

}