package com.android.assignment.base

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.DialogFragment
import com.android.assignment.R
import com.android.assignment.base.BaseFragment.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import kotlinx.android.synthetic.main.toolbar_base.*
import kotlinx.android.synthetic.main.toolbar_base.toolbar

abstract class BaseActivity : AppCompatActivity(), LeftMenuClickListener,
    View.OnClickListener, ToolbarListener, LoginSuccessListener {
    protected var fragment: DialogFragment? = null
    var onNavigationClick: OnNavigationClick? = null
    private var isLeftDrawerEnable = true
    private val isRightDrawerEnable = true

    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        onNavigationClick = this as OnNavigationClick
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mImageViewUser.setOnClickListener(View.OnClickListener {
            drawer_layout.openDrawer(
                GravityCompat.END
            )
        })
        if (nav_view != null) {
            setupDrawerContentLeft(nav_view)
        }
    }

    protected fun setHomeUpIndicator() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        if (supportActionBar != null) supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setHomeUpIndicator(colorId: Int) {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, colorId))
        if (supportActionBar != null) supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    protected fun setHomeUpButtonColor(colorId: Int) {
        val upArrow =
            ContextCompat.getDrawable(this, R.drawable.ic_menu)
    }

    protected fun setLayout(layoutId: Int) {
        layoutInflater.inflate(layoutId, layout_container)
    }

    protected fun initDrawer() { /*getSupportActionBar().setTitle("");*/ // mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        initDrawerToggle()
    }

    protected fun lockDrawer() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    private fun initDrawerToggle() {
        mDrawerToggle = object : ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.app_name,
            R.string.abc_action_bar_home_description
        ) {

        }
        drawer_layout.addDrawerListener(mDrawerToggle)
        if (supportActionBar != null) supportActionBar!!.setDisplayShowHomeEnabled(true)
        //        mDrawerToggle.syncState();
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (drawer_layout.isDrawerOpen(Gravity.RIGHT)) {
                    drawer_layout.closeDrawer(Gravity.RIGHT)
                } else {
                    if (isRightDrawerEnable) drawer_layout.openDrawer(Gravity.RIGHT)
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun showMenuButton() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        initDrawerToggle()
    }

    protected fun showBackButton() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        mDrawerToggle.isDrawerIndicatorEnabled = false
        val upArrow =
            ContextCompat.getDrawable(this, R.drawable.ic_back)
        setSupportActionBar(toolbar)
    }

    protected fun hideToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun setToolbarTitle(title: String?) {
        if (mTextViewTitleToolbar != null) mTextViewTitleToolbar.text = title
    }

    override fun setToolbarVisibility(value: Int) {
        toolbar.visibility = value
    }

    override fun setToolbar() {
        setHomeUpButtonColor(android.R.color.black)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSearchClick(searchName: String?) {}
    override fun onLeftMenuItemClick(fragmentType: Int) {}
    override fun onLoginSuccess() { //Dummy implementation
    }

    override fun onLogoutSuccess() { //Dummy Implementation.
    }

    override fun onClick(view: View) {
        when (view.id) {
            android.R.id.home -> {
            }
        }
    }

    // for left navigation drawer
    private fun setupDrawerContentLeft(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
            }
            menuItem.isChecked = true
            drawer_layout.closeDrawers()
            true
        }
    }

    interface OnNavigationClick {
        fun onNavigationClickListener(type: Int)
    }

    fun setLeftDrawerEnable(isLeftDrawerEnable: Boolean) {
        this.isLeftDrawerEnable = isLeftDrawerEnable
    }

    companion object {
        private const val TAG = "BaseActivity"
    }
}