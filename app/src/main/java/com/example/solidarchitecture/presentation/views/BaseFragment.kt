package com.example.solidarchitecture.presentation.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment


/** This file contains BaseFragment which will be used to create other fragment by extending this class and
 * with implmentation of all abstract methods available in this class.
 * onInflateLayout() - method will be used to inflate  content view from resource (xml) file.
 * setViewModel() -
 * bindViewModel() - method will be used to bind sub views with adapters if there is any listview /customview available.
 * setActionsToSubviews() - method will be used to set any action (event listener such as click event, scroll event, touch event etc)
 * **/


abstract class BaseFragment : Fragment() {
    protected abstract fun onInflateLayout(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    protected abstract fun setSubView(view: View)
    protected abstract fun setViewModel()
    protected abstract fun setActionsToSubviews()
    protected abstract fun bindViewModel()
    protected abstract fun setDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  onInflateLayout(inflater, container, savedInstanceState)

        setSubView(view!!)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setViewModel()

        setDataSource()

        bindViewModel()

        setActionsToSubviews()
    }

    fun Fragment.hideKeyboard() {
        val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    /*override fun onAttach(context: Context) {
        val appConfig = AppConfig.getInstance(requireContext())!!
        var local: String = AppLocale.JAPANESE.value

        if(appConfig.buildType == BuildType.DEVELOPMENT){
            local = AppLocale.ENGLISH.value
        }

        appConfig.localizer = AppLocalizer.Builder(requireContext()).addLocal(local).build()

        super.onAttach(appConfig.localizer.chnagelanguage())
    }*/
}
