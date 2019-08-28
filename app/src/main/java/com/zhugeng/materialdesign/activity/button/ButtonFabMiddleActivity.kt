package com.zhugeng.materialdesign.activity.button

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.serch_bar.*

class ButtonFabMiddleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_fab_middle)

        img_search.setOnClickListener {
            finish()
        }
    }

}