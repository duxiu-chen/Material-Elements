package com.zhugeng.materialdesign.activity.menu

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import com.zhugeng.materialdesign.R
import kotlinx.android.synthetic.main.activity_menu_drawer_dark.*
import kotlinx.android.synthetic.main.title_bar.*

class DrawerDarkActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Selected :${item.title}", Toast.LENGTH_SHORT).show()
        toolbar.title = item.title
        drawerLayout.closeDrawers()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_drawer_dark)

        initView()

    }

    private fun initView() {
        toolbar.title = "Drawer Simple Dark"
        drawerLayout.openDrawer(Gravity.START)
        var toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigation_view.setNavigationItemSelectedListener(this@DrawerDarkActivity)

    }

}