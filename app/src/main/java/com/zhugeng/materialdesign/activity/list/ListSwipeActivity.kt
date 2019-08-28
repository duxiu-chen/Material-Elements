package com.zhugeng.materialdesign.activity.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MotionEvent
import android.widget.Toast
import com.nikhilpanju.recyclerviewenhanced.OnActivityTouchListener
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.SwipeAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import kotlinx.android.synthetic.main.activity_grid_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*

class ListSwipeActivity: AppCompatActivity() ,RecyclerTouchListener.RecyclerTouchListenerHelper{

    private var onTouchListener: RecyclerTouchListener? = null
    private var touchListener: OnActivityTouchListener? = null

    private var datas: LinkedList<BottomSheetBasicBean> = LinkedList()
    private lateinit var adapter: SwipeAdapter
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_basic)
        initView()
        initListener()
    }
    private fun initView() {
        toolbar.title = "Swipe"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        for (item in names.withIndex()){
            var bean = BottomSheetBasicBean()
            bean.name = item.value;
            bean.resId = resIds[item.index]
            datas.add(bean)
        }

        adapter = SwipeAdapter(this, datas)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun initListener() {
        onTouchListener = RecyclerTouchListener(this, recyclerView)
        onTouchListener!!.setClickable(object : RecyclerTouchListener.OnRowClickListener {
            override fun onRowClicked(position: Int) {

            }

            override fun onIndependentViewClicked(independentViewID: Int, position: Int) {

            }
        })
                .setSwipeOptionViews(R.id.img_delete)
                .setSwipeable(R.id.rowFG, R.id.rowBG) { viewID, position ->
                    //按钮点击事件
                    if (viewID == R.id.img_delete) {
                        Toast.makeText(this@ListSwipeActivity, "Delete Clicked", Toast.LENGTH_SHORT).show()
                    }
                }


        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : SwipeAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {

            }
        })
    }

    override fun onResume() {
        super.onResume()
        recyclerView.addOnItemTouchListener(onTouchListener)

    }

    override fun onPause() {
        super.onPause()
        recyclerView.removeOnItemTouchListener(onTouchListener)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (touchListener != null) touchListener!!.getTouchCoordinates(ev)
        return super.dispatchTouchEvent(ev)
    }

    override fun setOnActivityTouchListener(listener: OnActivityTouchListener) {
        this.touchListener = listener
    }

}