package com.example.lib

import android.app.Activity
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.DisplayMetrics

/**
 * Created by bloder on 25/08/17.
 */
class Deck : ViewPager {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init { initView() }

    private fun initView() = this.setPageTransformer(true, CoverFlowTransformer())

    fun useDefaultPadding(context: Activity) {
        val metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)
        val padding = (metrics.widthPixels * 0.08).toInt()
        setPadding(padding, 0, padding, 0)
        clipToPadding = false
        pageMargin = 0
    }
}