package com.zhugeng.materialdesign.activity.bottomnavigation

import android.app.ProgressDialog
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_bottom_navigation_icon.*

class BottomNavigationIconActivity : AppCompatActivity() {
    private var resId : IntArray = IntArray(4)
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_icon)

        dialog = ProgressDialog(this)
        dialog.setMessage(getString(R.string.loading))

        img_menu.setOnClickListener {
            finish()
        }
        search_text.text = getString(R.string.home)

        tabLayout.getTabAt(0)!!.icon!!.setColorFilter(resources.getColor(R.color.icon_select), PorterDuff.Mode.SRC_IN)
        tabLayout.getTabAt(1)!!.icon!!.setColorFilter(resources.getColor(R.color.search_bar_menu), PorterDuff.Mode.SRC_IN)
        tabLayout.getTabAt(2)!!.icon!!.setColorFilter(resources.getColor(R.color.search_bar_menu), PorterDuff.Mode.SRC_IN)
        tabLayout.getTabAt(3)!!.icon!!.setColorFilter(resources.getColor(R.color.search_bar_menu), PorterDuff.Mode.SRC_IN)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                dialog.show()
                Handler().postDelayed(object : Runnable{
                    override fun run() {
                        if (dialog.isShowing)
                            dialog.dismiss()
                    }
                }, 800)
                tab.icon!!.setColorFilter(resources.getColor(R.color.icon_select), PorterDuff.Mode.SRC_IN)
                when(tab.position){
                    0 -> search_text.text = getString(R.string.home)
                    1 -> search_text.text = getString(R.string.search)
                    2 -> search_text.text = getString(R.string.favorite)
                    3 -> search_text.text = getString(R.string.profile)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon!!.setColorFilter(resources.getColor(R.color.search_bar_menu), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }

}