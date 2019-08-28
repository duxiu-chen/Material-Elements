package com.zhugeng.materialdesign.activity.chips

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_chips_basic.*
import kotlinx.android.synthetic.main.title_bar.*
import com.zhugeng.materialdesign.beans.ContactChip



class ChipsBasicActivity: AppCompatActivity() {
    private val resIds: Array<Int> = arrayOf(R.drawable.photo_female_1, R.drawable.photo_female_2,R.drawable.photo_male_1 ,
            R.drawable.photo_female_3, R.drawable.photo_male_2, R.drawable.photo_male_3, R.drawable.photo_female_4,
            R.drawable.photo_female_5, R.drawable.photo_female_6, R.drawable.photo_male_4, R.drawable.photo_male_5,
            R.drawable.photo_male_6, R.drawable.photo_female_7, R.drawable.photo_male_7, R.drawable.photo_female_8)
    private val names : Array<String> = arrayOf("Sarah Scott", "Susan Lee", "Anderson Thomas", "Betty C", "Roberts", "Adams Green",
            "Mary Jackson", "Betty L", "Elizabeth", "Kevin John", "Evans Collins", "Roberts Turner", "Garcia Lewis", "Miller Wilson", "Laura Michelle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chips_basic)
        init()
    }


    fun init(){
        toolbar.title = "Chips Basic"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        getData()
    }


    fun getData(){
        val contactList = ArrayList<ContactChip>()
        for (item in names.withIndex()){
            contactList.add(ContactChip(names[item.index],
                    "${names[item.index].toLowerCase().replace(" ",".")}@mail.com", getDrawable(resIds[item.index]), item.index))
        }
        chips_input.filterableList = contactList
    }

}