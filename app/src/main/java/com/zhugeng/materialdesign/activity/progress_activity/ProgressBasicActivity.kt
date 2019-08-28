package com.zhugeng.materialdesign.activity.progress_activity

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_progress_basic.*
import kotlinx.android.synthetic.main.title_bar.*



class ProgressBasicActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_basic)

        initView()

        initListener()

    }

    private fun initListener() {
        toolbar.setNavigationOnClickListener {finish()}
        var handler1 = Handler()
        handler1.post(Run1(handler1, progressbar_determinate))

        var handler2 = Handler()
        handler2.post(Run2(handler2, progressbar_buffer))

        var handler3 = Handler()
        handler3.post(Run3(handler3, progressbar_buffer))

        var handler4 = Handler()
        handler4.post(Run1(handler4, progressbar_circle))

    }

    private fun initView() {
        toolbar.title = "Basic"
    }

    class Run1 constructor(var handler: Handler, var progressBar: ProgressBar): Runnable{
        override fun run() {
            var progress = progressBar.progress + 10
            progressBar.progress = progress
            if (progress > 100) {
                progressBar.progress = 0
            }
            handler.postDelayed(this, 1000)
        }
    }

    class Run2 constructor(var handler: Handler, var progressBar: ProgressBar): Runnable{
        override fun run() {
            var progress = progressBar.progress + 5
            progressBar.progress = progress
            if (progress > 100) {
                progressBar.progress = 0
            }
            handler.postDelayed(this, 500)
        }
    }

    class Run3 constructor(var handler: Handler, var progressBar: ProgressBar): Runnable{
        override fun run() {
            var secondaryProgress = progressBar.secondaryProgress + 5
            progressBar.secondaryProgress = secondaryProgress
            if (secondaryProgress > 100 && progressBar.progress <= 10) {
                progressBar.secondaryProgress = 0
            }

            handler.postDelayed(this, 250)
        }
    }

}