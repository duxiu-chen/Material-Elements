package com.zhugeng.materialdesign.activity.pickers

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_date_light.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class DateDarkActivity: AppCompatActivity() {

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_light)

        initView()
    }

    private fun initView() {
        toolbar.title = "Date Dark"
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)

        var calander = Calendar.getInstance()

        mYear = calander.get(Calendar.YEAR)
        mMonth = calander.get(Calendar.MONTH)
        mDay = calander.get(Calendar.DAY_OF_MONTH)
        btn_get_date.setOnClickListener {
            DatePickerDialog(this, R.style.DarkDatePickerDialogTheme, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                mYear = year
                mMonth = month
                mDay = dayOfMonth
                tv_date.text ="$mYear-${mMonth+1}-$mDay"
            }, mYear, mMonth, mDay).show()
        }
    }

}