package com.zhugeng.materialdesign.activity.login

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_login_simple.*

class LoginSmipleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_simple)

        tv_forgot_password.setOnClickListener {
            Snackbar.make(ll_parent, "Forgot Password Clicked", Snackbar.LENGTH_SHORT).show()
        }
        btn_login.setOnClickListener { Snackbar.make(ll_parent, "Login Clicked", Snackbar.LENGTH_SHORT).show() }
        tv_sign_up.setOnClickListener { finish() }
    }

}