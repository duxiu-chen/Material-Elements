package com.zhugeng.materialdesign.activity.login

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_login_image_teal.*

class LoginImageTealActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login_image_teal)

        fab_login.setOnClickListener {
            fab_login.visibility = GONE
            progress.visibility = VISIBLE
            Handler().postDelayed({
                fab_login.visibility = VISIBLE
                progress.visibility = GONE
            },800)
        }
        tv_sign_up.setOnClickListener { finish() }
    }

}