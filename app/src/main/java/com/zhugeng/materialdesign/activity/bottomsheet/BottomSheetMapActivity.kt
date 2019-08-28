package com.zhugeng.materialdesign.activity.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.*
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_bottom_sheet_map.*
import kotlinx.android.synthetic.main.serch_bar.*

class BottomSheetMapActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_map)

        //获取到Bottom Sheet对象
        var bottomSheet: LinearLayout = findViewById(R.id.bottom_sheet)
        var behavior: BottomSheetBehavior<LinearLayout> = BottomSheetBehavior.from(bottomSheet)

        fab_loc.setOnClickListener {
            if (behavior.state == STATE_HIDDEN || behavior.state == STATE_EXPANDED)
                behavior.state = STATE_COLLAPSED
        }
        img_search.setOnClickListener {
            finish()
        }

    }

}