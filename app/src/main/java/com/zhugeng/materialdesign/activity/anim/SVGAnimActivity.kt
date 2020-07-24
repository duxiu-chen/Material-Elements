package com.zhugeng.materialdesign.activity.anim

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedStateListDrawable
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.acitvity_anim_svg.*
import kotlinx.android.synthetic.main.title_bar.*


class SVGAnimActivity: AppCompatActivity() {
    private var edit2pic = false
    private var isArrowoverflow:Boolean = false
    private var isCrossTick: Boolean = false
    private lateinit var anim: AnimatedVectorDrawable
    private lateinit var arrowoverflowAnim: AnimatedVectorDrawable
    private lateinit var fabCrossTickAnim: AnimatedVectorDrawable

    private var isChecked: Boolean = false
    private var finger = false

    private val STATE_SET_ON = intArrayOf(R.attr.state_on, -R.attr.state_off, -R.attr.state_error)
    private val STATE_SET_OFF = intArrayOf(-R.attr.state_on, R.attr.state_off, -R.attr.state_error)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_anim_svg)

        toolbar.title = "SVGAnim"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setNavigationOnClickListener {
            finish()
        }


        resetAnim()
        arrowoverflowReset()
        fabCrossTickAnimReset()
        fabEdit2Pic.setOnClickListener {
            anim.start()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                anim.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        edit2pic = !edit2pic
                        resetAnim()
                    }
                })
            }
        }
        fabArrowoverflow.setOnClickListener {
            arrowoverflowAnim.start()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                arrowoverflowAnim.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        isArrowoverflow = !isArrowoverflow
                        arrowoverflowReset()
                    }
                })
            }
        }
        fabCrossTick.setOnClickListener {
            fabCrossTickAnim.start()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                fabCrossTickAnim.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        isCrossTick = !isCrossTick
                        fabCrossTickAnimReset()
                    }
                })
            }
        }

        var imgAlarmClock = getDrawable(R.drawable.avd_clock_alarm) as AnimatedVectorDrawable
        imgAlarm.setImageDrawable(imgAlarmClock)
        imgAlarm.setOnClickListener { imgAlarmClock.start() }

        icon.setOnClickListener {
            if (finger){
                icon.setImageState(STATE_SET_ON, true)
            }else{
                icon.setImageState(STATE_SET_OFF, true)
            }
            finger = !finger
        }
        eye.setOnClickListener {
            isChecked = !isChecked
            val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked) 1 else -1)
            eye.setImageState(stateSet, true)
        }
    }

    private fun resetAnim(){
        anim = if(edit2pic){
            getDrawable(R.drawable.avd_pic2edit) as AnimatedVectorDrawable

        }else{
            getDrawable(R.drawable.avd_edit2pic) as AnimatedVectorDrawable

        }
        fabEdit2Pic.setImageDrawable(anim)
    }

    private fun arrowoverflowReset(){
        arrowoverflowAnim = if(isArrowoverflow){
            getDrawable(R.drawable.avd_pathmorph_arrowoverflow_arrow_to_overflow) as AnimatedVectorDrawable

        }else{
            getDrawable(R.drawable.avd_pathmorph_arrowoverflow_overflow_to_arrow) as AnimatedVectorDrawable

        }
        fabArrowoverflow.setImageDrawable(arrowoverflowAnim)
    }

    private fun fabCrossTickAnimReset(){
        fabCrossTickAnim = if(isCrossTick){
            getDrawable(R.drawable.avd_pathmorph_crosstick_cross_to_tick) as AnimatedVectorDrawable

        }else{
            getDrawable(R.drawable.avd_pathmorph_crosstick_tick_to_cross) as AnimatedVectorDrawable

        }
        fabCrossTick.setImageDrawable(fabCrossTickAnim)
    }

}