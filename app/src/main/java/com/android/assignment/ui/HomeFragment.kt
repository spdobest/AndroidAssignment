package com.android.assignment.ui

import android.os.Bundle
import android.view.View
import com.android.assignment.R
import com.android.assignment.base.BaseFragment


class HomeFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadMore()
    }
}
