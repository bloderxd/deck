package com.example.lib

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

/**
 * Created by bloder on 25/08/17.
 */
class Deck : ViewPager {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init { initView() }

    private fun initView() = this.setPageTransformer(true, CoverFlowTransformer())
}