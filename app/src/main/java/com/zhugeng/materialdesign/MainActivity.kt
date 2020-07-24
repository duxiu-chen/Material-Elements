package com.zhugeng.materialdesign

import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.zhugeng.materialdesign.activity.about.*
import com.zhugeng.materialdesign.activity.bottomnavigation.*
import com.zhugeng.materialdesign.activity.bottomsheet.BottomSheetBasicActivity
import com.zhugeng.materialdesign.activity.bottomsheet.BottomSheetFloatingActivity
import com.zhugeng.materialdesign.activity.bottomsheet.BottomSheetListActivity
import com.zhugeng.materialdesign.activity.bottomsheet.BottomSheetMapActivity
import com.zhugeng.materialdesign.activity.button.*
import com.zhugeng.materialdesign.activity.cards.CardsBasicActivity
import com.zhugeng.materialdesign.activity.cards.CardsOverlapActivity
import com.zhugeng.materialdesign.activity.cards.CardsWizardActivity
import com.zhugeng.materialdesign.activity.chips.ChipsBasicActivity
import com.zhugeng.materialdesign.activity.dialog.DialogBasicActivity
import com.zhugeng.materialdesign.activity.dialog.DialogCustomActivity
import com.zhugeng.materialdesign.activity.dialog.DialogTermActivity
import com.zhugeng.materialdesign.activity.expansion.ExpansionBasicActivity
import com.zhugeng.materialdesign.activity.expansion.ExpansionInvoiceActivity
import com.zhugeng.materialdesign.activity.grid.GridBasicActivity
import com.zhugeng.materialdesign.activity.grid.GridSectionedActivity
import com.zhugeng.materialdesign.activity.grid.GridSingleLineActivity
import com.zhugeng.materialdesign.activity.login.*
import com.zhugeng.materialdesign.activity.menu.DrawerDarkActivity
import com.zhugeng.materialdesign.activity.menu.DrawerLightActivity
import com.zhugeng.materialdesign.activity.menu.DrawerNewsActivity
import com.zhugeng.materialdesign.activity.menu.OverflowToolbarActivity
import com.zhugeng.materialdesign.activity.noitempage.NoArchivedActivity
import com.zhugeng.materialdesign.activity.noitempage.NoCityActivity
import com.zhugeng.materialdesign.activity.noitempage.NoInternetActivity
import com.zhugeng.materialdesign.activity.noitempage.NoSearchActivity
import com.zhugeng.materialdesign.activity.pickers.*
import com.zhugeng.materialdesign.activity.profile.*
import com.zhugeng.materialdesign.activity.progress_activity.*
import com.zhugeng.materialdesign.activity.snackbar_toast.BasicActivity
import com.zhugeng.materialdesign.activity.snackbar_toast.SnackbarAndFab
import com.zhugeng.materialdesign.activity.tab.TabBasicActivity
import com.zhugeng.materialdesign.activity.tab.TabIconActivity
import com.zhugeng.materialdesign.activity.tab.TabIconTextActivity
import com.zhugeng.materialdesign.activity.tab.TabScrollActivity
import com.zhugeng.materialdesign.activity.timeline.TimeLineDotCardActivity
import com.zhugeng.materialdesign.activity.timeline.TimeLineFeedActivity
import com.zhugeng.materialdesign.activity.timeline.TimeLinePathActivity
import com.zhugeng.materialdesign.adapter.ExpandAdapter
import com.zhugeng.materialdesign.beans.MenuBeans
import kotlinx.android.synthetic.main.activity_main.*
import com.umeng.analytics.MobclickAgent
import com.zhugeng.materialdesign.activity.anim.SVGAnimActivity
import com.zhugeng.materialdesign.activity.anim.SharedElementActivity
import com.zhugeng.materialdesign.activity.cards.CardsWizardOverlapActivity
import com.zhugeng.materialdesign.activity.dialog.DialogImageActivity
import com.zhugeng.materialdesign.activity.list.*


class MainActivity : AppCompatActivity() {

    private lateinit var list : MutableList<MenuBeans>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        img_about.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_about)
            dialog.setCancelable(true)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window.attributes)
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.findViewById<ImageView>(R.id.img_close).setOnClickListener {
                dialog.dismiss()
            }
            var verName = ""
            try {
                verName = packageManager.getPackageInfo(packageName, 0).versionName
            } catch (e : PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            dialog.findViewById<TextView>(R.id.tv_version).text = "Version $verName"
            dialog.show()
            dialog.window.attributes = layoutParams
        }

        expand_list_view.setAdapter(ExpandAdapter(list, this, expand_list_view))
        expand_list_view.setOnGroupExpandListener {
            for (i in 0..expand_list_view.expandableListAdapter.groupCount){
                if (it !== i) {// 关闭其他分组
                    expand_list_view.collapseGroup(i)
                }
            }
        }
        expand_list_view.setOnChildClickListener { _, v, groupPosition, childPosition, id ->
            when (groupPosition){
                0 ->when(childPosition){
                    0 -> startActivity(Intent(this, BottomNavigationBasicActivity::class.java))
                    1 -> startActivity(Intent(this, BottomNavigationShiftingActivity::class.java))
                    2 -> startActivity(Intent(this, BottomNavigationLightActivity::class.java))
                    3 -> startActivity(Intent(this, BottomNavigationDarkActivity::class.java))
                    4 -> startActivity(Intent(this, BottomNavigationIconActivity::class.java))
                    5 -> startActivity(Intent(this, BottomNavigationPrimaryActivity::class.java))
                    6 -> startActivity(Intent(this, BottomNavigationMainActivity::class.java))
                    7 -> startActivity(Intent(this, BottomNavigationInsertActivity::class.java))
                }

                1 ->when(childPosition){
                    0 -> startActivity(Intent(this, BottomSheetBasicActivity::class.java))
                    1 -> startActivity(Intent(this, BottomSheetListActivity::class.java))
                    2 -> startActivity(Intent(this, BottomSheetMapActivity::class.java))
                    3 -> startActivity(Intent(this, BottomSheetFloatingActivity::class.java))
                }

                2 ->when(childPosition){
                    0 -> startActivity(Intent(this, ButtonBasicActivity::class.java))
                    1 -> startActivity(Intent(this, ButtonUtilitiesActivity::class.java))
                    2 -> startActivity(Intent(this, ButtonFabMiddleActivity::class.java))
                    3 -> startActivity(Intent(this, FabMoreActivity::class.java))
                    4 -> startActivity(Intent(this, FabMoreTextActivity::class.java))
                }
                3 ->when(childPosition){
                    0 -> startActivity(Intent(this, CardsBasicActivity::class.java))
                    1 -> startActivity(Intent(this, CardsOverlapActivity::class.java))
                    2 -> startActivity(Intent(this, CardsWizardActivity::class.java))
                    3 -> startActivity(Intent(this, CardsWizardOverlapActivity::class.java))

                }
                4 ->when(childPosition){
                    0 -> startActivity(Intent(this, ChipsBasicActivity::class.java))
                }
                5 ->when(childPosition){
                    0 -> startActivity(Intent(this, DialogBasicActivity::class.java))
                    1 -> startActivity(Intent(this, DialogCustomActivity::class.java))
                    2 -> startActivity(Intent(this, DialogTermActivity::class.java))
                    3 -> startActivity(Intent(this, DialogImageActivity::class.java))
                }
                6 ->when(childPosition){
                    0 -> startActivity(Intent(this, ExpansionBasicActivity::class.java))
                    1 -> startActivity(Intent(this, ExpansionInvoiceActivity::class.java))
                }
                7 ->when(childPosition){
                    0 -> startActivity(Intent(this, GridBasicActivity::class.java))
                    1 -> startActivity(Intent(this, GridSingleLineActivity::class.java))
                    2 -> startActivity(Intent(this, GridSectionedActivity::class.java))
                }
                8 ->when(childPosition){
                    0 -> startActivity(Intent(this, ListBasicActivity::class.java))
                    1 -> startActivity(Intent(this, ListSectionActivity::class.java))
                    2 -> startActivity(Intent(this, ListAnimationActivity::class.java))
                    3 -> startActivity(Intent(this, ListDragActivity::class.java))
                    4 -> startActivity(Intent(this, ListSwipeActivity::class.java))
                }
                9 ->when(childPosition){
                    0 -> startActivity(Intent(this, DrawerNewsActivity::class.java))
                    1 -> startActivity(Intent(this, DrawerLightActivity::class.java))
                    2 -> startActivity(Intent(this, DrawerDarkActivity::class.java))
                    3 -> startActivity(Intent(this, OverflowToolbarActivity::class.java))
                }
                10 -> when(childPosition){
                    0 -> startActivity(Intent(this, DateLightActivity::class.java))
                    1 -> startActivity(Intent(this, DateDarkActivity::class.java))
                    2 -> startActivity(Intent(this, TimePickLightActivity::class.java))
                    3 -> startActivity(Intent(this, TimePickDarkActivity::class.java))
                    4 -> startActivity(Intent(this, ColorActivity::class.java))
                }
                11 -> when(childPosition){
                    0 -> startActivity(Intent(this, ProgressBasicActivity::class.java))
                    1 -> startActivity(Intent(this, ProgressLinearCenterActivity::class.java))
                    2 -> startActivity(Intent(this, ProgressCircleCenterActivity::class.java))
                    3 -> startActivity(Intent(this, ProgressDotsBoundsActivity::class.java))
                    4 -> startActivity(Intent(this, ProgressDotsFadeActivity::class.java))
                    5 -> startActivity(Intent(this, ProgressDotsGrowActivity::class.java))
                }
                12 ->when(childPosition){
                    0 -> startActivity(Intent(this, BasicActivity::class.java))
                    1 -> startActivity(Intent(this, SnackbarAndFab::class.java))
                }
                13 ->when(childPosition){
                    0 -> startActivity(Intent(this, TabBasicActivity::class.java))
                    1 -> startActivity(Intent(this, TabIconActivity::class.java))
                    2 -> startActivity(Intent(this, TabIconTextActivity::class.java))
                    3 -> startActivity(Intent(this, TabScrollActivity::class.java))
                }
                14 ->when(childPosition){
                    0 -> startActivity(Intent(this, Polygon::class.java))
                    1 -> startActivity(Intent(this, ProfilePurpleActivity::class.java))
                    2 -> startActivity(Intent(this, ProfileGalleryActivity::class.java))
                    3 -> startActivity(Intent(this, ProfileCardListActivity::class.java))
                    4 -> startActivity(Intent(this, ProfileImgAppbarActivity::class.java))
                }
                15 ->when(childPosition){
                    0 -> startActivity(Intent(this, NoArchivedActivity::class.java))
                    1 -> startActivity(Intent(this, NoSearchActivity::class.java))
                    2 -> startActivity(Intent(this, NoInternetActivity::class.java))
                    3 -> startActivity(Intent(this, NoCityActivity::class.java))
                }
                16 ->when(childPosition){
                    0 -> startActivity(Intent(this, TimeLineFeedActivity::class.java))
                    1 -> startActivity(Intent(this, TimeLinePathActivity::class.java))
                    2 -> startActivity(Intent(this, TimeLineDotCardActivity::class.java))
                }
                17 ->when(childPosition){
                    0 -> startActivity(Intent(this, LoginSmipleActivity::class.java))
                    1 -> startActivity(Intent(this, LoginSimpleGreenActivity::class.java))
                    2 -> startActivity(Intent(this, LoginImageTealActivity::class.java))
                    3 -> startActivity(Intent(this, LoginCardActivity::class.java))
                    4 -> startActivity(Intent(this, LoginCardOverlapActivity::class.java))
                }
                18 ->when(childPosition){
                    0 -> startActivity(Intent(this, App::class.java))
                    1 -> startActivity(Intent(this, AboutSimplyActivity::class.java))
                    2 -> startActivity(Intent(this, AboutSimplyBlueActivity::class.java))
                    3 -> startActivity(Intent(this, AboutCompanyActivity::class.java))
                    4 -> startActivity(Intent(this, AboutCompanyCardActivity::class.java))
                }
                19 ->when(childPosition){
                    0 -> startActivity(Intent(this, SVGAnimActivity::class.java))
                    1 -> startActivity(Intent(this, SharedElementActivity::class.java))
                }
            }
            return@setOnChildClickListener false
        }

    }

    private fun initData() {
        list = mutableListOf<MenuBeans>()
        var bottomNavigation :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        bottomNavigation.add(MenuBeans.ChildBeans("Basic"))
        bottomNavigation.add(MenuBeans.ChildBeans("Shifting"))
        bottomNavigation.add(MenuBeans.ChildBeans("Light"))
        bottomNavigation.add(MenuBeans.ChildBeans("Dark"))
        bottomNavigation.add(MenuBeans.ChildBeans("Icon"))
        bottomNavigation.add(MenuBeans.ChildBeans("Primary"))
        bottomNavigation.add(MenuBeans.ChildBeans("Main", true))
        bottomNavigation.add(MenuBeans.ChildBeans("Insert", true))
        list.add(MenuBeans("Bottom Navigation", R.drawable.ic_bottom_navigation, 0, bottomNavigation, true))

        var bottomSheet :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        bottomSheet.add(MenuBeans.ChildBeans("Basic"))
        bottomSheet.add(MenuBeans.ChildBeans("List"))
        bottomSheet.add(MenuBeans.ChildBeans("Map"))
        bottomSheet.add(MenuBeans.ChildBeans("Floating"))
        list.add(MenuBeans("Bottom Sheet", R.drawable.ic_bottom_sheet, 0, bottomSheet,false))

        var buutons :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        buutons.add(MenuBeans.ChildBeans("Basic"))
        buutons.add(MenuBeans.ChildBeans("Button In Utilities"))
        buutons.add(MenuBeans.ChildBeans("Fab Middle"))
        buutons.add(MenuBeans.ChildBeans("Fab More"))
        buutons.add(MenuBeans.ChildBeans("Fab More Text"))
        list.add(MenuBeans("Buttons", R.drawable.ic_buttons, 0, buutons,false))

        var cards :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        cards.add(MenuBeans.ChildBeans("Basic"))
        cards.add(MenuBeans.ChildBeans("Overlap"))
        cards.add(MenuBeans.ChildBeans("Wizard"))
        cards.add(MenuBeans.ChildBeans("Wizard Overlap"))
        list.add(MenuBeans("Cards", R.drawable.ic_cards, 0, cards,false))

        var chips :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        chips.add(MenuBeans.ChildBeans("Basic"))
        //chips.add(MenuBeans.ChildBeans("Tag"))
        list.add(MenuBeans("Chips", R.drawable.ic_chips, 0, chips,false))

        var dialog :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        dialog.add(MenuBeans.ChildBeans("Basic"))
        dialog.add(MenuBeans.ChildBeans("Custom"))
        dialog.add(MenuBeans.ChildBeans("Term of Services"))
        dialog.add(MenuBeans.ChildBeans("Image"))
        list.add(MenuBeans("Dialogs", R.drawable.ic_dialogs, 0, dialog,false))

        var expansionPanels :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        expansionPanels.add(MenuBeans.ChildBeans("Basic"))
        expansionPanels.add(MenuBeans.ChildBeans("Invoice"))
        list.add(MenuBeans("Expansion Panels", R.drawable.ic_expansion_panels, 0, expansionPanels,false))

        var grids :MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        grids.add(MenuBeans.ChildBeans("Basic"))
        grids.add(MenuBeans.ChildBeans("Single Line"))
        grids.add(MenuBeans.ChildBeans("Sectioned"))
        list.add(MenuBeans("Grids", R.drawable.ic_grid, 0, grids,false))

        var lists: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        lists.add(MenuBeans.ChildBeans("Basic"))
        lists.add(MenuBeans.ChildBeans("Sectioned"))
        lists.add(MenuBeans.ChildBeans("Animation"))
        lists.add(MenuBeans.ChildBeans("Draggable"))
        lists.add(MenuBeans.ChildBeans("Swipe"))
        list.add(MenuBeans("Lists", R.drawable.ic_lists, 0, lists,false))

        var menus: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        menus.add(MenuBeans.ChildBeans("Drawer News"))
        menus.add(MenuBeans.ChildBeans("Drawer Simple Light"))
        menus.add(MenuBeans.ChildBeans("Drawer Simple Dark"))
        menus.add(MenuBeans.ChildBeans("Overflow Toolbar"))
        list.add(MenuBeans("Menu", R.drawable.ic_menu, 0, menus,false))

        var pickers: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        pickers.add(MenuBeans.ChildBeans("Date Light"))
        pickers.add(MenuBeans.ChildBeans("Date Dark"))
        pickers.add(MenuBeans.ChildBeans("Time Light"))
        pickers.add(MenuBeans.ChildBeans("Time Dark"))
        pickers.add(MenuBeans.ChildBeans("Color RGB"))
        list.add(MenuBeans("Pickers", R.drawable.ic_pickers, 0, pickers,false))

        var progress: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        progress.add(MenuBeans.ChildBeans("Basic"))
        progress.add(MenuBeans.ChildBeans("Linear Center"))
        progress.add(MenuBeans.ChildBeans("Circle Center"))
        progress.add(MenuBeans.ChildBeans("Dots Bounce"))
        progress.add(MenuBeans.ChildBeans("Dots Fade"))
        progress.add(MenuBeans.ChildBeans("Dots Grow"))
        list.add(MenuBeans("Progress & Activity", R.drawable.ic_progress, 0, progress,false))

        var snackbar_toast: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        snackbar_toast.add(MenuBeans.ChildBeans("Basic"))
        snackbar_toast.add(MenuBeans.ChildBeans("Lift FAB"))
        list.add(MenuBeans("Snackbars & Toasts", R.drawable.ic_snackbars, 0, snackbar_toast,false))

        var tabs: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        tabs.add(MenuBeans.ChildBeans("Basic"))
        tabs.add(MenuBeans.ChildBeans("Icon"))
        tabs.add(MenuBeans.ChildBeans("Text & Icon"))
        tabs.add(MenuBeans.ChildBeans("Scroll"))
        list.add(MenuBeans("Tabs", R.drawable.ic_tab, 0, tabs,false))

        /*//分割线
        var divlier: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        list.add(MenuBeans("divlier", 0, 0, divlier,false))*/

        var profile: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        profile.add(MenuBeans.ChildBeans("Polygon"))
        profile.add(MenuBeans.ChildBeans("Purple"))
        profile.add(MenuBeans.ChildBeans("Gallery"))
        profile.add(MenuBeans.ChildBeans("Card List"))
        profile.add(MenuBeans.ChildBeans("Image Appbar"))
        list.add(MenuBeans("Profile", R.drawable.ic_profile, 0, profile,false))

        var no_item_page: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        no_item_page.add(MenuBeans.ChildBeans("Archived"))
        no_item_page.add(MenuBeans.ChildBeans("Search"))
        no_item_page.add(MenuBeans.ChildBeans("Internet Icon"))
        no_item_page.add(MenuBeans.ChildBeans("Bg City"))
        list.add(MenuBeans("No Item Page", R.drawable.ic_no_item_page, 0, no_item_page,false))


        var timeline: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        timeline.add(MenuBeans.ChildBeans("Timeline Feed"))
        timeline.add(MenuBeans.ChildBeans("TimeLine Path"))
        timeline.add(MenuBeans.ChildBeans("TimeLine Dot Card"))
        list.add(MenuBeans("Timeline", R.drawable.ic_timeline, 0, timeline,false))

        var login: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        login.add(MenuBeans.ChildBeans("Simple"))
        login.add(MenuBeans.ChildBeans("Simple Green"))
        login.add(MenuBeans.ChildBeans("Image Teal"))
        login.add(MenuBeans.ChildBeans("Card Light"))
        login.add(MenuBeans.ChildBeans("Card Overlap"))
        list.add(MenuBeans("Login", R.drawable.ic_login, 0, login,false))

        var about: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        about.add(MenuBeans.ChildBeans("App"))
        about.add(MenuBeans.ChildBeans("App Simple"))
        about.add(MenuBeans.ChildBeans("App Simple Blue"))
        about.add(MenuBeans.ChildBeans("Company"))
        about.add(MenuBeans.ChildBeans("Company Card"))
        list.add(MenuBeans("About", R.drawable.ic_device_information, 0, about,false))

        var anim: MutableList<MenuBeans.ChildBeans> = mutableListOf<MenuBeans.ChildBeans>()
        anim.add(MenuBeans.ChildBeans("SVG Anim", true))
        anim.add(MenuBeans.ChildBeans("Transition Anim", true))
        list.add(MenuBeans("Animation", R.drawable.ic_device_information, 0, anim,true))

    }


    public override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
    }

    public override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
    }
}
