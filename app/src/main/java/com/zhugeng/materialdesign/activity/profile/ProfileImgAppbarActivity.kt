package com.zhugeng.materialdesign.activity.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.tools.DensityUtil
import kotlinx.android.synthetic.main.activity_profile_img_appbar.*

class ProfileImgAppbarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_img_appbar)
        //此标记位是用来设置将状态栏设置成透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initView()

        initListener()
    }
    private fun initListener() {
        appbar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val value = DensityUtil.dp2px(this, 144f).toFloat()
            val scale = (value + verticalOffset)/ value
            fab.scaleX = scale
            fab.scaleY = scale
        }
    }

    private fun initView() {
        toolbar.title = "Image Appbar"
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}