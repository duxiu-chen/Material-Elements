package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zhugeng.materialdesign.R
import java.util.*

class GridSingleLineAdapter(private val data: IntArray, private val files: LinkedList<String>, private val context: Context): RecyclerView.Adapter<GridSingleLineAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_single_line, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], files[position] , context)
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(resId: Int, name:String, context: Context){
            var img = itemView.findViewById<ImageView>(R.id.item_img)
            var displayMetrics: DisplayMetrics = context.resources.displayMetrics

            img.layoutParams.width = displayMetrics.widthPixels/2 - 10
            img.layoutParams.height = displayMetrics.widthPixels/2 - 10
            img.requestLayout()
            img.setImageResource(resId)
            itemView.findViewById<TextView>(R.id.item_name).text = name
        }
    }
}