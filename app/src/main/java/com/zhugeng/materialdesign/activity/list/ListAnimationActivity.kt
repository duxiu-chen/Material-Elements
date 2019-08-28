package com.zhugeng.materialdesign.activity.list

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.ListBasicAdapter
import com.zhugeng.materialdesign.beans.ListBasicBean
import kotlinx.android.synthetic.main.activity_dialog_basic.*
import kotlinx.android.synthetic.main.activity_grid_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class ListAnimationActivity: AppCompatActivity() {
    private var datas: LinkedList<ListBasicBean> = LinkedList()
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")
    private val des = "Lorem ipsum dolor sit amet , consectetur adipiscing elit. Etiam efficitur ipsum in placerat molestie. Fusce quis mauris a enim sollicitudin"
    private var type = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animation)

        toolbar.title = "Animation"
        toolbar.inflateMenu(R.menu.menu_anim_list)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_refresh){
                when(type){
                    0 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_fade_in_list_item)
                    1 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_slide_from_left)
                    2 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_slide_from_right)
                    3 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_bottom_up)
                }
                recyclerView.adapter = ListBasicAdapter(LinkedList(),datas, this@ListAnimationActivity)
            }else if(it.itemId == R.id.menu_list){
                showDialog()
            }
            return@setOnMenuItemClickListener true
        }


        for (item in resIds.withIndex())
            datas.add(ListBasicBean(names[item.index], item.value, des))

        recyclerView.layoutManager = LinearLayoutManager(this)

        showDialog()
    }

    fun showDialog(){
        val items = arrayOf("Fade In", "Left to Right", "Right to Left", "Bottom Up")

        var builder = AlertDialog.Builder(this)
        val dialog = builder.create()
        dialog.setCancelable(false)
        var value = ""
        builder.setTitle("Animation Type")
        builder.setSingleChoiceItems(items,0) { dialog, which ->
            dialog.dismiss()
            type = which
            when(which){
                0 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_fade_in_list_item)
                1 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_slide_from_left)
                2 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_slide_from_right)
                3 -> recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ListAnimationActivity, R.anim.layout_anim_bottom_up)
            }
            recyclerView.adapter = ListBasicAdapter(LinkedList(),datas, this@ListAnimationActivity)
        }
        builder.show()
        builder.setCancelable(false)
    }

}