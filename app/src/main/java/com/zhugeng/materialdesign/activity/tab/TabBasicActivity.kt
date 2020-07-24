package com.zhugeng.materialdesign.activity.tab

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_tab_basic.*
import java.util.*


class TabBasicActivity: AppCompatActivity() {
    private val titles: LinkedList<String> = LinkedList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_basic)

        initView()
    }

    private fun initView() {
        toolbar.title = "Tab Basic"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        titles.add("ITEM ONE")
        titles.add("ITEM TWO")
        titles.add("ITEM THREE")
        var adapter = MyAdapter(this, titles)
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.setTabsFromPagerAdapter(adapter)
    }

    class MyAdapter constructor(var context: Context, private val titles: LinkedList<String>) : android.support.v4.view.PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun getCount(): Int {
            return titles.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var text: TextView = TextView(context)
            //text.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            text.text = "Section: ${position+1}"
            text.textSize = 28f
            text.gravity = Gravity.CENTER
            container.addView(text)
            return text
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }

}