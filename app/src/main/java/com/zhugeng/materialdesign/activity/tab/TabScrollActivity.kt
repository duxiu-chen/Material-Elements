package com.zhugeng.materialdesign.activity.tab

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.R.id.scrollable
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.MODE_SCROLLABLE
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.fragment.ContentFragment
import kotlinx.android.synthetic.main.activity_tab_icon_text.*
import java.util.*

class TabScrollActivity: AppCompatActivity() {

    private var fragments: LinkedList<Fragment> = LinkedList()
    private var titles: LinkedList<String> = LinkedList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_icon_text)

        initView()

    }

    private fun initView() {
        toolbar.title = "Scroll"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        titles.add("HOME")
        titles.add("TOP ARTISTS")
        titles.add("TOP ALBUMS")
        titles.add("NEW RELEASE")
        titles.add("TOP SONGS")

        fragments.add(ContentFragment())
        fragments.add(ContentFragment())
        fragments.add(ContentFragment())
        fragments.add(ContentFragment())
        fragments.add(ContentFragment())

        var adapter = MyAdapter(supportFragmentManager, fragments, titles)
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.tabMode = MODE_SCROLLABLE
    }

    class MyAdapter(fm: FragmentManager?, private var fragments: LinkedList<Fragment>, private var title: LinkedList<String>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
        override fun getPageTitle(position: Int): CharSequence? {
            return title[position]
        }
    }

}