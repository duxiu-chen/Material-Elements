package com.zhugeng.materialdesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import com.zhugeng.materialdesign.beans.MenuBeans
import android.widget.TextView
import com.balysv.materialripple.MaterialRippleLayout
import com.zhugeng.materialdesign.R


class ExpandAdapter(private var datas : MutableList<MenuBeans>,private val context : Context, val expandableListView: ExpandableListView) :BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return datas[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        //if (datas[groupPosition].title != "divlier"){
            var contentView :View
            var groupViewHolder :GroupViewHolder
            if (convertView == null) {
                contentView = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)
                groupViewHolder = GroupViewHolder()
                groupViewHolder.menuImg = contentView.findViewById(R.id.item_menu_pic)
                groupViewHolder.rightImg = contentView.findViewById(R.id.img_right)
                groupViewHolder.tvTitle = contentView.findViewById(R.id.tv_text)
                groupViewHolder.rippleLayout = contentView.findViewById(R.id.ripple_layout)
                contentView.tag = groupViewHolder
            } else {
                contentView = convertView
                groupViewHolder = convertView.tag as GroupViewHolder
            }
            groupViewHolder.tvTitle!!.text = datas[groupPosition].title
            groupViewHolder.menuImg!!.setImageResource(datas[groupPosition].resId)

            return contentView
        /*}else{
            var contentView :View = LayoutInflater.from(context).inflate(R.layout.layout_divlier, parent, false)
            return contentView
        }*/
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return datas[groupPosition].childBeans.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return datas[groupPosition].childBeans[childPosition].title
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var contentView :View
        var childViewHolder : ChildViewHolder
        if (convertView == null) {
            contentView = LayoutInflater.from(context).inflate(R.layout.item_menu_child, parent, false)
            childViewHolder = ChildViewHolder()
            childViewHolder.tvTitle = contentView.findViewById(R.id.item_title)
            contentView.tag = childViewHolder
        } else {
            contentView = convertView
            childViewHolder = convertView.tag as ChildViewHolder
        }
        childViewHolder.tvTitle!!.text = datas[groupPosition].childBeans[childPosition].title
        return contentView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return datas.size
    }

    internal class GroupViewHolder {
        var tvTitle: TextView? = null
        var menuImg: ImageView? = null
        var rightImg: ImageView? = null
        var rippleLayout: MaterialRippleLayout? =null
    }

    internal class ChildViewHolder {
        var tvTitle: TextView? = null
    }
}