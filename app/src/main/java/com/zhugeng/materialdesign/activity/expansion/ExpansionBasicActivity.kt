package com.zhugeng.materialdesign.activity.expansion

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_expansion_basic.*
import kotlinx.android.synthetic.main.title_bar.*

class ExpansionBasicActivity: AppCompatActivity() {
    private var isOpen = false
    private var isOpen2 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expansion_basic)

        toolbar.title = "Basic"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btn_show.setOnClickListener {
            if (!isOpen){
                ll_detail.visibility = VISIBLE
                ObjectAnimator.ofFloat(btn_show, "rotation", 0f, 180f)
                        .setDuration(250)
                        .start()
                isOpen = true
            }else{
                ll_detail.visibility = GONE
                ObjectAnimator.ofFloat(btn_show, "rotation", 180f, 0f)
                        .setDuration(250)
                        .start()
                isOpen = false
            }
        }
        btn_hide.setOnClickListener {
            ll_detail.visibility = GONE
            ObjectAnimator.ofFloat(btn_show, "rotation", 180f, 0f)
                    .setDuration(250)
                    .start()
            isOpen = false
        }

        btn_show2.setOnClickListener {
            if (!isOpen2){
                ll_detail2.visibility = VISIBLE
                ObjectAnimator.ofFloat(btn_show2, "rotation", 0f, 180f)
                        .setDuration(250)
                        .start()
                isOpen2 = true
            }else{
                ll_detail2.visibility = GONE
                ObjectAnimator.ofFloat(btn_show2, "rotation", 180f, 0f)
                        .setDuration(250)
                        .start()
                isOpen2 = false
            }
        }
        btn_save.setOnClickListener {
            ll_detail2.visibility = GONE
            ObjectAnimator.ofFloat(btn_show2, "rotation", 180f, 0f)
                    .setDuration(250)
                    .start()
            isOpen2 = false
            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
        }
    }

}