package com.android.assignment.ui

/**
 * Created by Sibaprasad Mohanty on 09/04/20.
 * Spm Limited
 * sp.dobest@gmail.com
 */

import android.os.Bundle
import com.android.assignment.R
import com.android.assignment.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        useLayout(base_container, R.layout.activity_home)
        showToolbarIcons(true)
    }
}
