package com.zhugeng.materialdesign.activity.expansion

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.tools.DensityUtil
import kotlinx.android.synthetic.main.activity_expansion_invoice.*

class ExpansionInvoiceActivity: AppCompatActivity() {

    private var isOpen = false
    private var isOpen2 = false
    private var height1 = 0
    private var height2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expansion_invoice)


        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btn_show.setOnClickListener {
            if (!isOpen){
                ll_detail.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(btn_show, "rotation", 0f, 180f)
                        .setDuration(250)
                        .start()
                var valueAnim: ValueAnimator = ValueAnimator.ofInt(0, DensityUtil.dp2px(this, 150f)).setDuration(200)
                valueAnim.addUpdateListener {
                    ll_detail.layoutParams.height = it.animatedValue as Int
                    ll_detail.requestLayout()
                }
                valueAnim.start()
                isOpen = true
            }else{
                ObjectAnimator.ofFloat(btn_show, "rotation", 180f, 0f)
                        .setDuration(250)
                        .start()
                var valueAnim: ValueAnimator = ValueAnimator.ofInt(DensityUtil.dp2px(this, 150f), 0 ).setDuration(200)
                valueAnim.addUpdateListener {
                    ll_detail.layoutParams.height = it.animatedValue as Int
                    ll_detail.requestLayout()
                    if (it.animatedValue == 0)
                        ll_detail.visibility = View.GONE
                }
                valueAnim.start()
                isOpen = false
            }
        }


        btn_show2.setOnClickListener {
            if (!isOpen2){
                ll_detail2.visibility = View.VISIBLE
                ObjectAnimator.ofFloat(btn_show2, "rotation", 0f, 180f)
                        .setDuration(250)
                        .start()
                var valueAnim: ValueAnimator = ValueAnimator.ofInt(0, DensityUtil.dp2px(this, 150f)).setDuration(200)
                valueAnim.addUpdateListener {
                    ll_detail2.layoutParams.height = it.animatedValue as Int
                    ll_detail2.requestLayout()
                }
                valueAnim.start()
                isOpen2 = true
            }else{
                ObjectAnimator.ofFloat(btn_show2, "rotation", 180f, 0f)
                        .setDuration(250)
                        .start()
                var valueAnim: ValueAnimator = ValueAnimator.ofInt(DensityUtil.dp2px(this, 150f), 0 ).setDuration(200)
                valueAnim.addUpdateListener {
                    ll_detail2.layoutParams.height = it.animatedValue as Int
                    ll_detail2.requestLayout()
                    if (it.animatedValue == 0)
                        ll_detail2.visibility = View.GONE
                }
                valueAnim.start()
                isOpen2 = false
            }
        }
    }

}