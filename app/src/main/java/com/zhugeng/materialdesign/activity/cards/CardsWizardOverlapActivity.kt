package com.zhugeng.materialdesign.activity.cards

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_cards_wizard_overlap.*
import java.util.*

class CardsWizardOverlapActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_wizard_overlap)
        viewpager.setPageTransformer(true, MyGallyPageTransformer())
        viewpager.adapter = MyPagerAdapter(this, viewpager)
        viewpager.offscreenPageLimit = 4
        initPoint()
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                changePoint(position)
                if (viewpager.currentItem == 3)
                    btn_next.text = "Get Started"
                else
                    btn_next.text = "Next"
            }

        })

        btn_next.setOnClickListener {
            if (viewpager.currentItem == 3)
                finish()
            else
                viewpager.setCurrentItem(viewpager.currentItem + 1, true)
        }
    }


    class MyPagerAdapter(private val activity: Activity, private var viewPager: ViewPager): PagerAdapter(){
        private val titles: Array<String> = arrayOf("Ready to Travel", "Pick the Ticket", "Flight to Destination", "Enjoy Holiday")
        private val contents: Array<String> = arrayOf("Choose your destination, plan Your trip. Pick the best place for Your holiday", "Select the day, pick Your ticket. We give you the best prices. We guarantee!", "Safe and Comfort flight is our priority. Professional crew and services.", "Enjoy your holiday, Don't forget to feel the moment and take a photo!")
        private val resIds: IntArray = intArrayOf(R.mipmap.img_wizard_1, R.mipmap.img_wizard_2, R.mipmap.img_wizard_3, R.mipmap.img_wizard_4)
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return titles.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var layoutInflater: LayoutInflater = LayoutInflater.from(activity)
            var view: View =  layoutInflater.inflate(R.layout.item_cards_wizard_overlap, container, false)
            view.findViewById<TextView>(R.id.title).text = titles[position]
            view.findViewById<TextView>(R.id.content).text = contents[position]
            view.findViewById<ImageView>(R.id.item_card_img).setImageResource(resIds[position])

            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }
    }

    /**
     * 加载底部圆点
     */
    private fun initPoint() {
        val ivPointArray: LinkedList<ImageView> = LinkedList()
        //根据ViewPager的item数量实例化数组
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        val size = 4
        for (i in 0 until size) {
            val layoutParams_tv = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams_tv.gravity = Gravity.CENTER
            layoutParams_tv.leftMargin = 10
            layoutParams_tv.rightMargin = 10
            layoutParams_tv.height = 16
            layoutParams_tv.width = 16
            val iv_point = ImageView(this)
            ivPointArray.add(iv_point)
            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0) {
                iv_point.setBackgroundResource(R.drawable.cycler_textview)
            } else {
                iv_point.setBackgroundResource(R.drawable.cycler_textview_read)
            }
            //将数组中的ImageView加入到ViewGroup
            guide_point.addView(ivPointArray[i], layoutParams_tv)
        }
    }

    private fun changePoint(pos: Int) {
        val size = guide_point.childCount
        for (i in 0 until size) {
            if (i == pos)
                guide_point.getChildAt(i).setBackgroundResource(R.drawable.cycler_textview)
            else
                guide_point.getChildAt(i).setBackgroundResource(R.drawable.cycler_textview_read)
        }
    }

    inner class MyGallyPageTransformer : ViewPager.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            val scaleFactor = Math.max(0.85f, 1 - Math.abs(position))
            if (position < -1) {
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else if (position < 0) {
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else if (position >= 0 && position < 1) {
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else if (position >= 1) {
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            }
        }
    }

}