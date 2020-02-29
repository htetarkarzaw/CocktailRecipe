package com.htetarkarzaw.cocktailrecipe.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.htetarkarzaw.cocktailrecipe.fragments.AlcoholicFragment

class PagerAdapter(private val myContext: Context, fm: FragmentManager, private var totalTabs: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> {
                AlcoholicFragment().newInstance(true)
            }
            1 -> {
                AlcoholicFragment().newInstance(false)
            }
            else -> null
        }
    }


    override fun getCount(): Int {
        return totalTabs
    }
}

