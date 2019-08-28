package com.zhugeng.materialdesign.activity.bottomnavigation

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.tools.DensityUtil
import kotlinx.android.synthetic.main.activity_bottom_navigation_shifting.*
import kotlinx.android.synthetic.main.serch_bar.*

class BottomNavigationShiftingActivity : AppCompatActivity() {
    private var isAnim: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_shifting)

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

        val colors = IntArray(4)
        colors[0] = ContextCompat.getColor(this@BottomNavigationShiftingActivity, R.color.bottom_movie)
        colors[1] = ContextCompat.getColor(this@BottomNavigationShiftingActivity, R.color.bottom_music)
        colors[2] = ContextCompat.getColor(this@BottomNavigationShiftingActivity, R.color.bottom_books)
        colors[3] = ContextCompat.getColor(this@BottomNavigationShiftingActivity, R.color.newsstand)

        bottomNavigation.setOnNavigationItemSelectedListener {
            val bottoMenu : BottomNavigationView = bottomNavigation
            var i : Int = 0
            search_text.text = it.title
            when(it.title){
                getString(R.string.movie) -> {
                    i = 0
                }
                getString(R.string.music) ->{
                    i = 1
                }
                getString(R.string.books) -> {
                    i = 2
                }
                getString(R.string.newsstand) ->{
                    i = 3
                }
            }
            bottoMenu.setBackgroundColor(colors[i])
            return@setOnNavigationItemSelectedListener true
        }

    }

}