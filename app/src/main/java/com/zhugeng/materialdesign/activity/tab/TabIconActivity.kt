package com.zhugeng.materialdesign.activity.tab

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.fragment.ContentFragment
import kotlinx.android.synthetic.main.activity_tab_icon.*
import java.util.*
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager


class TabIconActivity: AppCompatActivity() {
    private var fragments: LinkedList<Fragment> = LinkedList()
    private var datas: IntArray = intArrayOf(R.drawable.ic_music,
            R.drawable.ic_movie,
            R.drawable.ic_book,
            R.drawable.ic_newsstand)
    private var resId: LinkedList<Drawable> = LinkedList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_icon)

        initView()

        initListener()
    }

    private fun initListener() {
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                tabLayout.setScrollPosition(position, positionOffset, false)
            }

            override fun onPageSelected(position: Int) {

                for (item in 0..3){
                    var img = tabLayout.getTabAt(item)!!.customView!!.findViewById<ImageView>(R.id.tab_icon)
                    img.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.white2))
                }
                var img = tabLayout.getTabAt(position)!!.customView!!.findViewById<ImageView>(R.id.tab_icon)
                img.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.white))

            }

        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                for (item in 0..3){
                    var img = tabLayout.getTabAt(item)!!.customView!!.findViewById<ImageView>(R.id.tab_icon)
                    img.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.white2))
                }
                var img = tab!!.customView!!.findViewById<ImageView>(R.id.tab_icon)
                img.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                viewpager.currentItem = tab.position
            }

        })
        viewpager.currentItem = 0

    }

    private fun initView() {
        toolbar.title = "Tab Icon"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        fragments.add(ContentFragment())
        fragments.add(ContentFragment())
        fragments.add(ContentFragment())
        fragments.add(ContentFragment())

        resId.add(resources.getDrawable(R.drawable.ic_music))
        resId.add(resources.getDrawable(R.drawable.ic_movie))
        resId.add(resources.getDrawable(R.drawable.ic_book))
        resId.add(resources.getDrawable(R.drawable.ic_newsstand))
        for (item in 0..3){
            var view = layoutInflater.inflate(R.layout.item_tablayout_tab, null)
            var img = view.findViewById<ImageView>(R.id.tab_icon)
            img.setImageResource(datas[item])
            if (item == 0)
                img.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
            var tab = tabLayout.newTab()
            tab.customView = view
            tabLayout.addTab(tab)
        }

        var adapter = MyAdapter(supportFragmentManager, fragments, resId)
        viewpager.adapter = adapter
        //tabLayout.setupWithViewPager(viewpager)
    }

    class MyAdapter(fm: FragmentManager?, private var fragments: LinkedList<Fragment>, private var resId: LinkedList<Drawable>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
        /*override fun getPageTitle(position: Int): CharSequence? {
            val drawable: Drawable = resId[position]
            drawable!!.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
            val imageSpan = ImageSpan(drawable, ImageSpan.ALIGN_BASELINE)
            val spannableString = SpannableString("                                ")
            spannableString.setSpan(imageSpan, 24, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            return spannableString
        }*/
    }

}