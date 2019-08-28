package com.zhugeng.materialdesign.activity.pickers

import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_date_light.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class TimePickDarkActivity: AppCompatActivity() {

    private var mHour: Int = 0
    private var mMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_light)

        initView()

    }

    private fun initView() {
        toolbar.title = "Time Pick Dark"
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)

        btn_get_date.text = "PICK TIME"

        var date = Date()

        mMinute = date.minutes
        mHour = date.hours
        btn_get_date.setOnClickListener {
            TimePickerDialog(this, 4 , TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tv_date.text = "$hourOfDay : $minute"
            }, mHour, mMinute, true).show()
        }
    }

}