package com.zhugeng.materialdesign.activity.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zhugeng.materialdesign.R
import com.zhugeng.materialdesign.adapter.ListBasicAdapter
import com.zhugeng.materialdesign.beans.ListBasicBean
import kotlinx.android.synthetic.main.activity_grid_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import java.util.*
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags
import android.widget.Toast
import com.zhugeng.materialdesign.adapter.BottomSheetBasicAdapter
import com.zhugeng.materialdesign.beans.BottomSheetBasicBean
import java.util.Collections.swap

class ListDragActivity: AppCompatActivity() {
    private var datas: LinkedList<BottomSheetBasicBean> = LinkedList()
    private lateinit var adapter: BottomSheetBasicAdapter
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_basic)

        toolbar.title = "Drag"
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
        var mItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = 0
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
                //得到当拖拽的viewHolder的Position
                val fromPosition = viewHolder!!.adapterPosition
                //拿到当前拖拽到的item的viewHolder
                val toPosition = target!!.adapterPosition
                if (fromPosition < toPosition) {
                    for (i in fromPosition until toPosition) {
                        Collections.swap(datas, i, i + 1)
                    }
                } else {
                    for (i in fromPosition downTo toPosition + 1) {
                        Collections.swap(datas, i, i - 1)
                    }
                }
                adapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        mItemTouchHelper.attachToRecyclerView(recyclerView)
        adapter.setOnClickListener(object : BottomSheetBasicAdapter.OnClickListent{
            override fun onClick(pos: Int, data: BottomSheetBasicBean) {
                Toast.makeText(this@ListDragActivity, "${data.name} Clicked!", Toast.LENGTH_SHORT).show()
            }
        })
    }

}