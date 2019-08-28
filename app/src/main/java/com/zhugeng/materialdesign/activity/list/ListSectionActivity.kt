package com.zhugeng.materialdesign.activity.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.ListBasicAdapter
import com.zhugeng.materialdesign.beans.ListBasicBean
import kotlinx.android.synthetic.main.activity_grid_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class ListSectionActivity: AppCompatActivity(){
    private var datas: LinkedList<ListBasicBean> = LinkedList()
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")
    private val des = "Lorem ipsum dolor sit amet , consectetur adipiscing elit. Etiam efficitur ipsum in placerat molestie. Fusce quis mauris a enim sollicitudin"
    private val titles: LinkedList<String> = LinkedList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_basic)

        toolbar.title = "Sectioned"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        titles.add("January")
        titles.add("February")
        titles.add("March")
        titles.add("April")
        titles.add("May")
        titles.add("June")
        titles.add("July")
        titles.add("August")

        for (item in resIds.withIndex()){
            if (item.index%4 == 0)
                datas.add(ListBasicBean(null, 0, null))
            datas.add(ListBasicBean(names[item.index], item.value, des))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListBasicAdapter(titles, datas, this)
    }

}