package com.zhugeng.materialdesign.activity.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_dialog_basic.*
import kotlinx.android.synthetic.main.title_bar.*

class DialogBasicActivity: AppCompatActivity(){
    private val items = arrayOf("上海", "北京", "湖南", "湖北", "海南")
    private val itemColors = arrayOf("Red", "Green", "Blue", "Purple", "Olive")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_basic)
        toolbar.title = "Basic"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        confirmation_dialog.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Use Google's location services ?")
            builder.setMessage("The location service will be opened and the location is accurate. This service will consume a lot of electricity.")
            builder.setPositiveButton("Agree", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }

            })
            builder.setNegativeButton("Disagree", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }

            })
            builder.show()
        }
        alert_dialog.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            val dialog = builder.create()
            builder.setTitle("Discard draft?")
            builder.setPositiveButton("Discard", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Snackbar.make(nestedScrollView, "Discard Clicked!" , Snackbar.LENGTH_SHORT).show()
                }

            })
            builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }

            })
            builder.show()
            builder.setCancelable(false)
        }
        single_choice_dialog.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            val dialog = builder.create()
            var value = ""
            builder.setTitle("Where are you going?")
            builder.setSingleChoiceItems(items,0 ,object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    value = items[which]
                }
            })
            builder.setPositiveButton("Ok", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Snackbar.make(nestedScrollView, "Selected: $value" , Snackbar.LENGTH_SHORT).show()
                }

            })
            builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog!!.dismiss()
                }

            })
            builder.show()
            builder.setCancelable(false)
        }

        multiple_choice_dialog.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            val dialog = builder.create()
            var value = ""
            builder.setTitle("You preferred colors?")
            builder.setMultiChoiceItems(itemColors, booleanArrayOf(false, false, false, false, false)) { dialog, which, isChecked -> }
            builder.setPositiveButton("Ok") { dialog, which -> Snackbar.make(nestedScrollView, "Data Submitted!" , Snackbar.LENGTH_SHORT).show() }
            builder.setNegativeButton("Cancel") { dialog, which -> dialog!!.dismiss() }
            builder.show()
            builder.setCancelable(false)
        }

    }

}