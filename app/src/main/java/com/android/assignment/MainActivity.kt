package com.android.assignment

import android.os.Bundle
import com.android.assignment.base.BaseActivity
import com.android.assignment.ui.HomeFragment
import kotlinx.android.synthetic.main.activity_base.*

class MainActivity : BaseActivity(), BaseActivity.OnNavigationMenuClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        useLayout(base_container, R.layout.activity_main)
        showToolbarIcons(true)


        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_from_right, R.anim.slide_out_to_left,
                R.anim.slide_in_from_left, R.anim.slide_out_to_right
            )
            .replace(R.id.fragmentContainerView, HomeFragment())
            .commit()
    }

    override fun onNavigationMenuClick(type: Int) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_from_right, R.anim.slide_out_to_left,
                R.anim.slide_in_from_left, R.anim.slide_out_to_right
            )
            .replace(R.id.fragmentContainerView, HomeFragment())
            .commit()
    }
}
