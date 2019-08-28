package com.zhugeng.materialdesign.activity.pickers

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_picker_color.*
import kotlinx.android.synthetic.main.dialog_color.*
import kotlinx.android.synthetic.main.title_bar.*

class ColorActivity: AppCompatActivity(){

    private var red :Int = 0
    private var blue :Int = 0
    private var green :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picker_color)

        initView()
        initListener()
    }

    private fun initListener() {

        btn_get_date.setOnClickListener {
            showDialog()
        }
    }

    private fun initView() {
        toolbar.title = "Color"
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.menu_bottom_navigation_dark_toolbar)
    }

    private fun showDialog() {
        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_color)
        dialog.setCancelable(true)
        var layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window.attributes)
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT

        var view = dialog.findViewById<View>(R.id.bg)
        var redValue = dialog.findViewById<TextView>(R.id.red_value)
        var greenValue = dialog.findViewById<TextView>(R.id.green_value)
        var blueValue = dialog.findViewById<TextView>(R.id.blue_value)

        var seekRed = dialog.findViewById<SeekBar>(R.id.seekbar_red)
        var seekGreen = dialog.findViewById<SeekBar>(R.id.seekbar_green)
        var seekBlue = dialog.findViewById<SeekBar>(R.id.seekbar_blue)

        seekRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                redValue.text = progress.toString()
                red = progress
                changeBG(view)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        seekBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blueValue.text = progress.toString()
                blue = progress
                changeBG(view)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        seekGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                greenValue.text = progress.toString()
                green = progress
                changeBG(view)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        seekRed.progress = red
        seekGreen.progress = green
        seekBlue.progress = blue

        dialog.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.findViewById<Button>(R.id.btn_ok).setOnClickListener {
            tv_date.text = "RGB( $red , $green, $blue )"
            dialog.dismiss()
        }

        dialog.show()
        dialog.window.attributes = layoutParams
    }

    private fun changeBG(view: View){
        var sb = StringBuffer("#")
        var r = Integer.toHexString(red)
        var g = Integer.toHexString(green)
        var b = Integer.toHexString(blue)
        if (r.length == 1)
            sb.append("0$r")
        else
            sb.append(r)

        if (g.length == 1)
            sb.append("0$g")
        else
            sb.append(g)

        if (b.length == 1)
            sb.append("0$b")
        else
            sb.append(b)

        view.setBackgroundColor(Color.parseColor(sb.toString()))
        tv_date.setTextColor(Color.parseColor(sb.toString()))
    }

}