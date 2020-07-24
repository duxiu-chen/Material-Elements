package com.zhugeng.materialdesign.activity.profile

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_profile_polygon.*
import android.support.v4.view.ViewCompat.setScaleX
import android.util.Log
import com.zhugeng.materialdesign.tools.DensityUtil


class Polygon: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_polygon)

        initView()

        initListener()
    }

    private fun initListener() {
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { p0, p1 ->
            val value = DensityUtil.dp2px(this@Polygon, 144f).toFloat()
            val scale = (value + p1)/ value
            img_user.scaleX = scale
            img_user.scaleY = scale
        })
    }

    private fun initView() {
        toolbar.title = "Polygon"
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    class MyListener constructor(private var img: CircleImageView, private var coll: CollapsingToolbarLayout): AppBarLayout.OnOffsetChangedListener {
        override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
            Log.e("verticalOffset:", "$verticalOffset")
        }
    }

}