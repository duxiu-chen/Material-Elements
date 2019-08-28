package com.zhugeng.materialdesign.activity.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_dialog_term.*
import kotlinx.android.synthetic.main.title_bar.*

class DialogTermActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_term)

        toolbar.title = "Term"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btn_term_of_services.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_term_of_services)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            dialog.show()
            dialog.window.attributes = layoutParams
            dialog.findViewById<ImageButton>(R.id.btn_close).setOnClickListener {
                dialog.dismiss()
            }
            dialog.findViewById<Button>(R.id.btn_accept).setOnClickListener {
                Toast.makeText(this, "Accept Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<Button>(R.id.btn_decline).setOnClickListener {
                Toast.makeText(this, "Decline Clicked!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}