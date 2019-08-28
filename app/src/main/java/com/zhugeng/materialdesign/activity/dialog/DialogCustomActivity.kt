package com.zhugeng.materialdesign.activity.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_dialog_custom.*
import kotlinx.android.synthetic.main.title_bar.*
import android.support.v7.widget.AppCompatButton
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast


class DialogCustomActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_custom)
        toolbar.title = "Custom"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        btn_custom_info.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_info)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.findViewById<AppCompatButton>(R.id.app_btn_start).setOnClickListener {
                Toast.makeText(this, "Get Started Clicked!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()
            dialog.window.attributes = layoutParams
        }
        btn_custom_warning.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_warning)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.findViewById<AppCompatButton>(R.id.app_btn_retry).setOnClickListener {
                Toast.makeText(this, "Retry Clicked!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()
            dialog.window.attributes = layoutParams
        }
        btn_custom_light.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_light)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.findViewById<AppCompatButton>(R.id.app_btn_follow).setOnClickListener {
                Toast.makeText(this, "Follow Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ImageView>(R.id.img_close).setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
            dialog.window.attributes = layoutParams
        }
        btn_custom_dark.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_dark)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.findViewById<AppCompatButton>(R.id.app_btn_follow).setOnClickListener {
                Toast.makeText(this, "Follow Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ImageView>(R.id.img_close).setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
            dialog.window.attributes = layoutParams
        }
        btn_custom_post.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_custom_post)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            var button = dialog.findViewById<AppCompatButton>(R.id.btn_post)
            button.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(this, "Post Submitted!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ImageButton>(R.id.img_photo).setOnClickListener {
                Toast.makeText(this, "Photo Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ImageButton>(R.id.img_link).setOnClickListener {
                Toast.makeText(this, "Link Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<ImageButton>(R.id.img_more).setOnClickListener {
                Toast.makeText(this, "More Clicked!", Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<EditText>(R.id.edit).addTextChangedListener(object :TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                    button.isClickable = !s.toString().isNullOrEmpty()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

            })
            button.isClickable = false
            dialog.show()
            dialog.window.attributes = layoutParams
        }
    }

}