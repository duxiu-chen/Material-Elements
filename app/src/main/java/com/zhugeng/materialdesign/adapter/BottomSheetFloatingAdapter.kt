package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.beans.BottomSheetFloatingBean
import kotlinx.android.synthetic.main.item_bottom_sheet_floating.view.*
import java.util.*

class BottomSheetFloatingAdapter(private val context: Context, private var datas: LinkedList<BottomSheetFloatingBean>)
    : RecyclerView.Adapter<BottomSheetFloatingAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.item_bottom_sheet_floating, parent, false))
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(datas[position])
        holder.itemView.setOnClickListener {
            if (onClickListener != null){
                onClickListener.onClick(position, datas[position])
            }
        }
    }


    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(bottomSheetFloatingBean: BottomSheetFloatingBean){
            itemView.item_img.setImageResource(bottomSheetFloatingBean.resId)
            itemView.item_title.text = bottomSheetFloatingBean.title
            itemView.item_time.text = bottomSheetFloatingBean.time
        }
    }


    private lateinit var onClickListener: OnClickListent

    fun setOnClickListener(onClickListener: OnClickListent){
        this.onClickListener = onClickListener
    }

    interface OnClickListent{
        fun onClick(pos:Int, data: BottomSheetFloatingBean)
    }

}