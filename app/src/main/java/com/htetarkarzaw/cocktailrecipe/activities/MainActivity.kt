package com.htetarkarzaw.cocktailrecipe.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.htetarkarzaw.cocktailrecipe.viewmodels.MainViewModel
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.adapters.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : _BaseActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

    }

    private fun setup() {
        tab_layout.addTab(tab_layout.newTab().setText("Alcoholic"))
        tab_layout.addTab(tab_layout.newTab().setText("Non-Alcoholic"))
        val adapter = PagerAdapter(this, supportFragmentManager, tab_layout!!.tabCount)
        mainViewPager.adapter=adapter
        mainViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mainViewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}
