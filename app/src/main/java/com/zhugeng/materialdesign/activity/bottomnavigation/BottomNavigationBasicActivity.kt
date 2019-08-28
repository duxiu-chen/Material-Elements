package com.zhugeng.materialdesign.activity.bottomnavigation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.tools.DensityUtil
import kotlinx.android.synthetic.main.activity_bottom_navigation_basic.*
import kotlinx.android.synthetic.main.serch_bar.*

class BottomNavigationBasicActivity : AppCompatActivity(){

    private var isAnim: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_basic)

        nestedScrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (scrollY - oldScrollY > 10){
                if (!isAnim){
                    isAnim = true
                    ObjectAnimator.ofFloat(bottomNavigation, "translationY",
                            0f,  DensityUtil.dp2px(this, 56f).toFloat())
                            .setDuration(350)
                            .start()

                    ObjectAnimator.ofFloat(search_bar, "translationY", search_bar.top.toFloat(),
                            search_bar.top.toFloat() - DensityUtil.dp2px(this, 88f))
                            .setDuration(350)
                            .start()
                }
            }else if (scrollY - oldScrollY < -10){
                if (isAnim){
                    isAnim = false
                    ObjectAnimator.ofFloat(bottomNavigation, "translationY",
                            DensityUtil.dp2px(this, 56f).toFloat(), 0f)
                            .setDuration(350)
                            .start()

                    ObjectAnimator.ofFloat(search_bar, "translationY",
                            search_bar.top.toFloat() - DensityUtil.dp2px(this, 88f), 0f)
                            .setDuration(350)
                            .start()
                }
            }
        }

        img_search.setOnClickListener {
            finish()
        }

        bottomNavigation.setOnNavigationItemSelectedListener {
            search_text.text = it.title

            return@setOnNavigationItemSelectedListener true
        }
    }

}