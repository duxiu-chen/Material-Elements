package com.zhugeng.materialdesign.activity.menu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.BottomSheetBasicAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import kotlinx.android.synthetic.main.activity_menu_overflow_toolbar.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class OverflowToolbarActivity: AppCompatActivity() , Toolbar.OnMenuItemClickListener {
    override fun onMenuItemClick(item: MenuItem?): Boolean {

        return true
    }

    private var datas: LinkedList<BottomSheetBasicBean> = LinkedList()
    private lateinit var adapter: BottomSheetBasicAdapter
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_overflow_toolbar)

        initView()
        initListener()
    }

    private fun initListener() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener(this@OverflowToolbarActivity)
        adapter.setOnClickListener(object : BottomSheetBasicAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {

            }
        })
    }

    private fun initView() {
        toolbar.title = "Overflow Toolbar"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_overflow_toolbar)

        for (item in names.withIndex()){
            var bean : BottomSheetBasicBean = BottomSheetBasicBean()
            bean.name = item.value
            bean.resId = resIds[item.index]
            datas.add(bean)
        }

        adapter = BottomSheetBasicAdapter(this, datas)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}