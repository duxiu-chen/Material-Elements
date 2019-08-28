package com.zhugeng.materialdesign.activity.menu

import android.app.Activity
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.title_bar.*
import com.zhugeng.materialdesign.R.id.toolbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Gravity.START
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_menu_drawer_news.*
import android.widget.Toast
import com.zhugeng.materialdesign.adapter.BottomSheetBasicAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import java.util.*


class DrawerNewsActivity:AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener {

    private var datas: LinkedList<BottomSheetBasicBean> = LinkedList()
    private lateinit var adapter: BottomSheetBasicAdapter
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Selected :${item.title}", Toast.LENGTH_SHORT).show()
        toolbar.title = item.title
        drawerLayout.closeDrawers()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_drawer_news)

        initView()
        initListener()
    }

    private fun initListener() {
        design_navigation_view.setNavigationItemSelectedListener(this@DrawerNewsActivity)
        adapter.setOnClickListener(object : BottomSheetBasicAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {

            }
        })
    }

    private fun initView() {
        toolbar.title = "Drawer News"
        drawerLayout.openDrawer(START)
        var toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        for (item in names.withIndex()){
            var bean :BottomSheetBasicBean = BottomSheetBasicBean()
            bean.name = item.value;
            bean.resId = resIds[item.index]
            datas.add(bean)
        }
        adapter = BottomSheetBasicAdapter(this, datas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}