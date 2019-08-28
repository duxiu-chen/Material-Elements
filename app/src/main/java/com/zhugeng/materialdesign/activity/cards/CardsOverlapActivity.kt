package com.zhugeng.materialdesign.activity.cards

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_cards_overlap.*

class CardsOverlapActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_overlap)
        nestedScrollView.bringToFront()
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}