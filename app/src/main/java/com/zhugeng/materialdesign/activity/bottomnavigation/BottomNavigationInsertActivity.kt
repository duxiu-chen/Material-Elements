package com.zhugeng.materialdesign.activity.bottomnavigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_bottom_navigation_insert.*

class BottomNavigationInsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_insert)

        bottom_app_bar.inflateMenu(R.menu.menu_anim_list)

        bottom_app_bar.setNavigationOnClickListener { finish() }

    }

}