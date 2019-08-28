package com.zhugeng.materialdesign.activity.login

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_login_card.*

class LoginCardActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login_card)

        tv_forgot_password.setOnClickListener {
            Snackbar.make(ll_parent, "Forgot Password Clicked", Snackbar.LENGTH_SHORT).show()
        }
        tv_login.setOnClickListener { finish() }
    }

}