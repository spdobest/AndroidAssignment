package com.android.assignment.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.assignment.R
import kotlinx.android.synthetic.main.fragment_base.*
import kotlin.properties.Delegates

abstract class BaseFragment : Fragment() {

    private var mLayoutId by Delegates.notNull<Int>()
    private lateinit var toolbarListener: ToolbarListener

    interface ToolbarListener {
        fun setToolbarTitle(title: String?)
        fun setToolbarVisibility(value: Int)
        fun setToolbar()
        fun onCartSelect()
        fun onNotificationSelect()
        fun onSearchSelect()
    }

    interface LoginSuccessListener {
        fun onLoginSuccess()
        fun onLogoutSuccess()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            toolbarListener = context as ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context as Activity).localClassName
                        + " must implement MenuClickListener, ToolbarListener, LoginSuccessListener"
            )
        }
    }

    protected fun setEmptyView(view: TextView) {
        view.visibility = View.VISIBLE
        view.setText(R.string.data_not_available)
    }

    protected fun setEmptyView(view: TextView, message: String?) {
        view.text = message
    }

    protected fun hideProgressBar() {
        if (progressbarLoading != null) progressbarLoading.visibility = View.GONE
    }

    protected fun showProgressBar() {
        if (progressbarLoading != null) progressbarLoading.visibility = View.VISIBLE
    }

    protected fun hideLoadMoreProgress() {
        if (progressbarLoadMore != null) progressbarLoadMore.visibility = View.GONE
        if (progressbarLoading != null) progressbarLoading.visibility = View.GONE
    }

    protected fun showLoadMoreProgress() {
        if (progressbarLoadMore != null) progressbarLoadMore.visibility = View.VISIBLE
    }

    protected fun showToast(activity: Activity?, msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false)
        inflater.inflate(mLayoutId, fragment_layout_container)
        return view
    }

    protected fun setLayout(layoutId: Int) {
        mLayoutId = layoutId
    }

    // ON OPTION MENU SELECTED
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        }
        return super.onOptionsItemSelected(item)
    }
}