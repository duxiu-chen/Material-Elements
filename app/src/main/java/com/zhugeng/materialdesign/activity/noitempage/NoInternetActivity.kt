package com.zhugeng.materialdesign.activity.noitempage

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_no_internet.*
import kotlinx.android.synthetic.main.title_bar.*

class NoInternetActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)

        toolbar.title = "Search"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }


        ll_main.setOnClickListener {
            ll_main.visibility = GONE
            progress.visibility = VISIBLE
            Handler().postDelayed({
                ll_main.visibility = VISIBLE
                progress.visibility = GONE
            }, 2000)
        }

    }

}