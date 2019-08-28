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
import com.zhugeng.materialdesign.beans.ListBasicBean
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ListBasicAdapter(private val titles:LinkedList<String>, private val data: LinkedList<ListBasicBean>, private val context: Context):
        RecyclerView.Adapter<ListBasicAdapter.MyViewHolder>(){

    private val TITLE = 1
    private val NORMAL = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return if (viewType == TITLE)
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_sectioned_title, parent, false))
        else
            MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_basic, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].des.isNullOrEmpty())
            TITLE
        else
            NORMAL
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (getItemViewType(position) == 2){
            holder.bind(data[position])
        }else{
            holder.bind(titles[position/5])
        }

    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ListBasicBean){

            itemView.findViewById<CircleImageView>(R.id.head_img).setImageResource(item.resId)
            itemView.findViewById<TextView>(R.id.item_name).text = item.name
            itemView.findViewById<TextView>(R.id.item_des).text = item.des

        }

        fun bind(title:String){
            itemView.findViewById<TextView>(R.id.item_title).text = title
        }

    }

}