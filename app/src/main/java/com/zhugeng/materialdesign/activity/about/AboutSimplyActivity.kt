package com.zhugeng.materialdesign.activity.about

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_about_simply.*

class AboutSimplyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_simply)

        toolbar.title = "About"
        toolbar.setNavigationIcon(R.drawable.ic_back_black)
        toolbar.setTitleTextColor(resources.getColor(R.color.black))
        toolbar.inflateMenu(R.menu.menu_app_black)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}