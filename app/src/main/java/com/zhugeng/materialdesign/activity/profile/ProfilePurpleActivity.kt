package com.zhugeng.materialdesign.activity.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_profile_purple.*

class ProfilePurpleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_purple)

        initView()

    }

    private fun initView() {
        toolbar.title = "Purple"
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}