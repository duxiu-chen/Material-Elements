package com.zhugeng.materialdesign.activity.noitempage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_no_city.*
import kotlinx.android.synthetic.main.title_bar.*

class NoCityActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_city)

        toolbar.title = "City"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        fab.setOnClickListener { Toast.makeText(this,"Upload Clicked!", Toast.LENGTH_SHORT).show() }

    }

}