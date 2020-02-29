package com.htetarkarzaw.cocktailrecipe.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.htetarkarzaw.cocktailrecipe.viewmodels.MainViewModel
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.adapters.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_tab.*
import kotlinx.android.synthetic.main.custom_tab.view.*


class MainActivity : _BaseActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

    }

    private fun setup() {
        tab_layout.addTab(tab_layout.newTab())
        tab_layout.addTab(tab_layout.newTab())
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = PagerAdapter(this, supportFragmentManager, tab_layout!!.tabCount)
        mainViewPager.adapter=adapter
        mainViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        for (i in 0..tab_layout.tabCount) {
            val tabLinearLayout = LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
            tab_layout.getTabAt(i)?.customView = tabLinearLayout
        }
        tab_layout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mainViewPager!!.currentItem = tab.position
                var view = tab_layout.getTabAt(tab.position)?.customView
                view!!.tabLayout.setBackgroundColor(getColor(R.color.colorAccent))
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
//                tab_layout[tab.position].setBackgroundColor(getColor(R.color.white))
            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

//    private fun setupTabLayout(viewPager: ViewPager, viewPagerAdapter:  ,tabLayout : TabLayout) {
//        tabLayout.setupWithViewPager(viewPager)
//
//        val length = tabLayout.tabCount
//        for (i in 0 until length) {
//            tabLayout.getTabAt(i)!!.setCustomView(viewPagerAdapter.getTabView(i))
//        }
//    }
}
