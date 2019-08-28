package com.zhugeng.materialdesign.activity.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_profile_card_list.*

class ProfileCardListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_card_list)

        initView()

    }
    private fun initView() {
        img_back.setOnClickListener { finish() }
    }
}