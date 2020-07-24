package com.zhugeng.materialdesign.activity.anim

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_anim_transition.*
import android.support.v4.util.Pair
import com.zhugeng.materialdesign.activity.profile.ProfileImgAppbarActivity
import kotlinx.android.synthetic.main.title_bar.*

class SharedElementActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_transition)

        toolbar.title = "TransitionAnim"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val intent1 = Intent(this@SharedElementActivity, Detail1Activity::class.java)

        cardGrade1.setOnClickListener {
            cardGrade1.transitionName = getString(R.string.card_transition_name)
            val pair1 = Pair.create(cardGrade1, cardGrade1.transitionName) as Pair<View, String>
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SharedElementActivity, pair1)
            startActivity(intent1, options.toBundle())
        }

        val intent2 = Intent(this@SharedElementActivity, ProfileImgAppbarActivity::class.java)

        cardGrade2.setOnClickListener {
            item_head_img.transitionName = getString(R.string.img_transition_name)
            item_tv_name.transitionName = getString(R.string.tv_transition_name)
            val pair1 = Pair.create(item_head_img, item_head_img.transitionName) as Pair<View, String>
            val pair2 = Pair.create(item_tv_name, item_tv_name.transitionName) as Pair<View, String>
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SharedElementActivity, pair1, pair2)
            startActivity(intent2, options.toBundle())
        }


    }

}