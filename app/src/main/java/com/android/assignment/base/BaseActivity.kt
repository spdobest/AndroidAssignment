package com.android.assignment.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.assignment.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
