package com.zhugeng.materialdesign.activity.grid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.GridSectionedAdapter
import kotlinx.android.synthetic.main.activity_grid_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class GridSectionedActivity: AppCompatActivity() {

    private lateinit var adapter: GridSectionedAdapter

    private val data: IntArray = intArrayOf(0, R.mipmap.image_1, R.mipmap.image_2, R.mipmap.image_3,
            R.mipmap.image_4, R.mipmap.image_5, R.mipmap.image_6,
            0, R.mipmap.image_7, R.mipmap.image_8, R.mipmap.image_9,
            R.mipmap.image_10, R.mipmap.image_11, R.mipmap.image_12,
            0, R.mipmap.image_13, R.mipmap.image_14, R.mipmap.image_15,
            R.mipmap.image_16, R.mipmap.image_17, R.mipmap.image_18,
            0, R.mipmap.image_19, R.mipmap.image_20, R.mipmap.image_21,
            R.mipmap.image_22, R.mipmap.image_23, R.mipmap.image_24,
            0, R.mipmap.image_25, R.mipmap.image_26, R.mipmap.image_27,
            R.mipmap.image_28, R.mipmap.image_29, R.mipmap.image_30,
            0, R.mipmap.image_1, R.mipmap.image_2, R.mipmap.image_7,
            R.mipmap.image_18, R.mipmap.image_9, R.mipmap.image_5)
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

        adapter = GridSectionedAdapter(data, titles, this)

        recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

}