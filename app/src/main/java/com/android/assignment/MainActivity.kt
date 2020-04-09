package com.android.assignment

import android.os.Bundle
import com.android.assignment.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        useLayout(base_container, R.layout.activity_main)
        showToolbarIcons(true)
    }

    override fun onCartSelect() {

    }

    override fun onNotificationSelect() {

    }

    override fun onSearchSelect() {

    }
}
