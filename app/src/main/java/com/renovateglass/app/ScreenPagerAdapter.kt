package com.renovateglass.app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.renovateglass.app.ui.WebContentFragment

class ScreenPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val screens = listOf(
        WebContentFragment.newInstance("html/dashboard.html"),
        WebContentFragment.newInstance("html/tasks.html"),
        WebContentFragment.newInstance("html/shopping.html"),
        WebContentFragment.newInstance("html/create.html")
    )

    override fun getItemCount(): Int = screens.size

    override fun createFragment(position: Int): Fragment = screens[position]
}
