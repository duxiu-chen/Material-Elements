package com.zhugeng.materialdesign.activity.progress_activity

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AnimationUtils
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.ProgressAdapter
import com.zhugeng.materialdesign.beans.ProgressBeans
import kotlinx.android.synthetic.main.activity_progress_linear_center.*
import java.util.*

class ProgressLinearCenterActivity: AppCompatActivity(){
    private var data = LinkedList<ProgressBeans>()
    private lateinit var adapter: ProgressAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_linear_center)

        initView()
        initListener()
    }

    private fun initListener() {
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.menu_progress)
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_reset){
                adapter.clear()
                startAnim()
            }
            return@setOnMenuItemClickListener true
        }
        startAnim()
    }

    private fun initView() {
        adapter = ProgressAdapter(data, this)
    }

    fun initData(){
        data.add(ProgressBeans("Folders", true))
        data.add(ProgressBeans("Photos", "Jan 9, 2014", R.drawable.ic_folder_black_24dp, false))
        data.add(ProgressBeans("Recipes", "Jan 17, 2014", R.drawable.ic_folder_black_24dp, false))
        data.add(ProgressBeans("Work", "Jan 28, 2014", R.drawable.ic_folder_black_24dp, false))
        data.add(ProgressBeans("Files", true))
        data.add(ProgressBeans("Vacation itinerary", "Jan 9, 2014", R.drawable.ic_file, false))
        data.add(ProgressBeans("Kitchen Remodel", "Jan 17, 2014", R.drawable.ic_file, false))
        data.add(ProgressBeans("To Do Note", "Jan 28, 2014", R.drawable.ic_file, false))
    }

    fun startAnim(){
        var handler = Handler()
        ll_progress.alpha = 1f
        handler.postDelayed(Runnable {
            var anim = ObjectAnimator.ofFloat(ll_progress, "alpha", 1f, 0f)
            anim.duration = 500
            anim.addUpdateListener {
                var x: Float = it.animatedValue as Float
                if (x == 0f){
                    recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(this@ProgressLinearCenterActivity, R.anim.layout_anim_fade_in_list_item)
                    recyclerView.layoutManager = LinearLayoutManager(this@ProgressLinearCenterActivity)
                    initData()
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
            anim.start()
        }, 1800)
    }

}