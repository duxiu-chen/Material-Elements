package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class BottomSheetBasicAdapter(private var context:Context, private var datas: LinkedList<BottomSheetBasicBean>) :
        RecyclerView.Adapter<BottomSheetBasicAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.item_bottom_sheet_basic, parent, false))
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


    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(bean: BottomSheetBasicBean){
            itemView.findViewById<TextView>(R.id.item_tv_name).text = bean.name
            itemView.findViewById<CircleImageView>(R.id.item_head_img).setImageResource(bean.resId)
        }
    }


    private lateinit var onClickListener: OnClickListent

    fun setOnClickListener(onClickListener: OnClickListent){
        this.onClickListener = onClickListener
    }

    interface OnClickListent{
        fun onClick(pos:Int, data: BottomSheetBasicBean)
    }

}