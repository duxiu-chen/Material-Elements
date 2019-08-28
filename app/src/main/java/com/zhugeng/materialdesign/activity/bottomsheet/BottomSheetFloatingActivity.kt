package com.zhugeng.materialdesign.activity.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.BottomSheetFloatingAdapter
import com.zhugeng.materialdesign.beans.BottomSheetFloatingBean
import kotlinx.android.synthetic.main.activity_bottom_sheet_floating.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class BottomSheetFloatingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_floating)

        toolbar.title = "Floating"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        showDialog(getData()[0])

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        var adapter = BottomSheetFloatingAdapter(this, getData())
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : BottomSheetFloatingAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetFloatingBean) {
                showDialog(data)
            }
        })
    }

    private fun getData(): LinkedList<BottomSheetFloatingBean> {
        var datas :LinkedList<BottomSheetFloatingBean> = LinkedList<BottomSheetFloatingBean>()
        datas.add(BottomSheetFloatingBean(R.mipmap.image_13, resources.getString(R.string.backpacker), "2015-10-05"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_6, resources.getString(R.string.park_bench), "2013-03-05"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_4, resources.getString(R.string.keyboard), "2013-04-22"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_15, resources.getString(R.string.mist_mountain), "2015-06-23"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_10, resources.getString(R.string.coffee_camera), "2015-06-23"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_3, resources.getString(R.string.city_building), "2016-02-01"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_2, resources.getString(R.string.desk), "2015-06-23"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_7, resources.getString(R.string.cocktails), "2015-10-05"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_12, resources.getString(R.string.hill), "2013-04-22"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_8, resources.getString(R.string.side_park), "2016-07-08"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_1, resources.getString(R.string.night_street), "2015-10-15"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_14, resources.getString(R.string.forest), "2015-01-08"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_9, resources.getString(R.string.clothes), "2013-07-08"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_5, resources.getString(R.string.window), "2014-10-15"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_11, resources.getString(R.string.flower), "2016-01-08"))
        datas.add(BottomSheetFloatingBean(R.mipmap.image_4, resources.getString(R.string.keyboard), "2013-04-22"))

        return datas
    }

    private fun showDialog(bean: BottomSheetFloatingBean){
        var dialog: BottomSheetDialog = BottomSheetDialog(this, R.style.bottom_sheet_dialog)
        val view : View = layoutInflater.inflate(R.layout.bottom_sheet_floating, null)
        view.findViewById<TextView>(R.id.tv_title).text = bean.title
        view.findViewById<TextView>(R.id.tv_time).text = bean.time
        view.findViewById<ImageView>(R.id.img_close).setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view, ViewGroup.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT))
        dialog.show()
    }

}