package com.zhugeng.materialdesign.activity.button

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.BottomSheetBasicAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import com.zhugeng.materialdesign.tools.DensityUtil
import kotlinx.android.synthetic.main.activity_fab_more_text.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class FabMoreTextActivity: AppCompatActivity() {

    private var datas: LinkedList<BottomSheetBasicBean> = LinkedList()
    private lateinit var adapter: BottomSheetBasicAdapter
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")

    private var isOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab_more_text)

        toolbar.title = "Fab More Text"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        for (item in names.withIndex()){
            var bean :BottomSheetBasicBean = BottomSheetBasicBean()
            bean.name = item.value;
            bean.resId = resIds[item.index]
            datas.add(bean)
        }

        adapter = BottomSheetBasicAdapter(this, datas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        initListener()

    }

    private fun initListener() {
        fab_add.setOnClickListener {
            if (isOpen){
                closeAnim()
            }else{
                openAnim()
            }
        }

        fab_voice.setOnClickListener {
            Toast.makeText(this, "Voice Clicked!", Toast.LENGTH_SHORT).show()
        }
        fab_contact.setOnClickListener {
            Toast.makeText(this, "Contact Clicked!", Toast.LENGTH_SHORT).show()
        }

        adapter.setOnClickListener(object : BottomSheetBasicAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {
                Toast.makeText(this@FabMoreTextActivity, "${data.name} Clicked!", Toast.LENGTH_SHORT).show()
            }

        })

        mask.setOnClickListener{
            closeAnim()
        }
    }

    fun openAnim(){
        isOpen = true
        mask.visibility = VISIBLE
        ObjectAnimator.ofFloat(ll_contact, "translationY",
                0f, - DensityUtil.dp2px(this, 56f).toFloat())
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(ll_voice, "translationY",
                0f, - DensityUtil.dp2px(this, 104f).toFloat())
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(card_contact, "alpha", 0f, 1f)
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(card_voice, "alpha", 0f, 1f)
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(fab_add, "rotation", 0f, 45f)
                .setDuration(200)
                .start()
    }

    fun closeAnim(){
        isOpen = false
        mask.visibility = GONE
        ObjectAnimator.ofFloat(ll_contact, "translationY",
                - DensityUtil.dp2px(this, 56f).toFloat(), 0f)
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(ll_voice, "translationY",
                - DensityUtil.dp2px(this, 104f).toFloat(), 0f)
                .setDuration(240)
                .start()
        ObjectAnimator.ofFloat(card_contact, "alpha", 1f, 0f)
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(card_voice, "alpha", 1f, 0f)
                .setDuration(200)
                .start()
        ObjectAnimator.ofFloat(fab_add, "rotation", 45f, 0f)
                .setDuration(200)
                .start()
    }

}