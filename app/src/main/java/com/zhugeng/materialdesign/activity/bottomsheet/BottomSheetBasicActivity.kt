package com.zhugeng.materialdesign.activity.bottomsheet

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.*
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.BottomSheetBasicAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import kotlinx.android.synthetic.main.activity_bottom_sheet_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*



class BottomSheetBasicActivity : AppCompatActivity() {
    private lateinit var  behavior: BottomSheetBehavior<View>

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
        setContentView(R.layout.activity_bottom_sheet_basic)

        init()

    }

    private fun init() {
        toolbar.title = "Basic"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        for (item in names.withIndex()){
            var bean :BottomSheetBasicBean = BottomSheetBasicBean()
            bean.name = item.value;
            bean.resId = resIds[item.index]
            datas.add(bean)
        }

        behavior = BottomSheetBehavior.from(bottom_sheet)

        adapter = BottomSheetBasicAdapter(this, datas)
        adapter.setOnClickListener(object : BottomSheetBasicAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {
                showBottomSheet(data)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        showBottomSheet(datas[0])
    }

    private fun showBottomSheet(data: BottomSheetBasicBean) {

        if (behavior.state == STATE_EXPANDED)
            behavior.state = STATE_COLLAPSED

        var dialog: BottomSheetDialog = BottomSheetDialog(this)
        val view : View = layoutInflater.inflate(R.layout.bottom_sheet_basic, null)
        view.findViewById<TextView>(R.id.tv_name).text = data.name
        view.findViewById<TextView>(R.id.tv_close).setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view)
        dialog.show()
    }
}