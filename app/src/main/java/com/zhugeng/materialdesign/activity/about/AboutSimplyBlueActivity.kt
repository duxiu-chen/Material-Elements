package com.zhugeng.materialdesign.activity.about

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_about_simply.*

class AboutSimplyBlueActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_simply_blue)

        toolbar.title = "About"
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}