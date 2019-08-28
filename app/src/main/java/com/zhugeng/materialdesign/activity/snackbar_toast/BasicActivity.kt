package com.zhugeng.materialdesign.activity.snackbar_toast

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.widget.TextView
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_snackbar_toast_basic.*
import kotlinx.android.synthetic.main.title_bar.*

class BasicActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_toast_basic)

        initView()
        initListener()
    }

    private fun initView() {
        toolbar.title = "Snackbar & Toast"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun initListener() {
        app_btn_toast_simple.setOnClickListener {
            Toast.makeText(this, "Simple Toast", Toast.LENGTH_SHORT).show()
        }
        app_btn_toast_layout.setOnClickListener {
            var  view = layoutInflater.inflate(R.layout.toast_layout, null)
            var toast = Toast(this)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = view
            toast.show()
        }
        app_btn_toast_color.setOnClickListener {
            var  view = layoutInflater.inflate(R.layout.toast_layout, null)
            var toast = Toast(this)
            view!!.findViewById<CardView>(R.id.card_toast).setBackgroundColor(resources.getColor(R.color.orange))
            view!!.findViewById<TextView>(R.id.tv_toast).setTextColor(resources.getColor(R.color.white))
            toast.duration = Toast.LENGTH_SHORT
            toast.view = view
            toast.show()
        }

        app_btn_snackbar_simple.setOnClickListener {
            Snackbar.make(ll_parent, "Simple Snackbar!", Snackbar.LENGTH_SHORT).show()
        }
        app_btn_snackbar_action.setOnClickListener {
                Snackbar.make(ll_parent, "Snackbar With Action", Snackbar.LENGTH_LONG).setAction("UNDO", {
                    Snackbar.make(ll_parent, "UNDO Clicked!", Snackbar.LENGTH_SHORT).show()
                }).show()

        }
    }

}