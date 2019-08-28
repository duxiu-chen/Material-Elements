package com.zhugeng.materialdesign.activity.menu;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.zhugeng.materialdesign.R;

public class DrawerLightActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private DrawerLayout drawer;

    int[][] state = new int[][] {
            new int[] {android.R.attr.state_selected},
            new int[] {-android.R.attr.state_selected}
    };

    int[] color = new int[] {
            Color.BLACK,
            Color.BLUE
    };

    ColorStateList ColorStateList1 = new ColorStateList(state, color);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer_light);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Drawer Simple Light");
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationClick(this, drawer));
    }


    class NavigationClick implements  NavigationView.OnNavigationItemSelectedListener{
        private Activity activity;
        private DrawerLayout drawerLayout;
        public NavigationClick(Activity activity, DrawerLayout drawerLayout){
            this.drawerLayout = drawerLayout;
            this.activity = activity;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Toast.makeText(activity, "Selected : " + item.getTitle(), Toast.LENGTH_SHORT).show();
            toolbar.setTitle(item.getTitle());
            drawerLayout.closeDrawers();
            return true;
        }
    }
}
