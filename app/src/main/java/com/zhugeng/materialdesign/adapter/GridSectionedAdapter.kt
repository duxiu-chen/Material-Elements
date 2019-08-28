package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zhugeng.materialdesign.R
import java.util.*

class GridSectionedAdapter(private val data: IntArray, private val titles:LinkedList<String>, private val context: Context):
        RecyclerView.Adapter<GridSectionedAdapter.MyViewHolder>() {
    private val TITLE = 1
    private val NORMAL = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if (viewType == TITLE)
            return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_sectioned_title, parent, false))
        else
            return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_basic, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        if (data[position] == 0)
            return TITLE
        else
            return NORMAL
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(titles[position/7], data[position], context, getItemViewType(position))
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(title:String, resId: Int, context: Context, type: Int){
            if (type == 2){
                var img = itemView.findViewById<ImageView>(R.id.item_img)
                var displayMetrics: DisplayMetrics = context.resources.displayMetrics

                img.layoutParams.width = displayMetrics.widthPixels/3 - 10
                img.layoutParams.height = displayMetrics.widthPixels/3 - 10
                img.requestLayout()
                img.setImageResource(resId)
            }else{
                var layoutParams: StaggeredGridLayoutManager.LayoutParams = StaggeredGridLayoutManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.isFullSpan = true
                itemView.layoutParams= layoutParams
                itemView.findViewById<TextView>(R.id.item_title).text = title
            }
        }
    }
}