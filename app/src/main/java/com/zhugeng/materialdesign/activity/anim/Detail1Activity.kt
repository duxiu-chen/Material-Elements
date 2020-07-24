package com.zhugeng.materialdesign.activity.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_detail1.*
import kotlinx.android.synthetic.main.title_bar.*

class Detail1Activity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail1)

        toolbar.title = "Detail 1"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        card.transitionName = getString(R.string.card_transition_name)
    }

}