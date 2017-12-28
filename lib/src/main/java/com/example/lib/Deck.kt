package com.example.lib

import android.app.Activity
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue

/**
 * Created by bloder on 25/08/17.
 */
private const val DEFAULT_PERCENTAGE_PADDING = 8

class Deck : ViewPager {

    private val pageTransformer = CoverFlowTransformer()

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        initView()
    }

    private fun initView() {
        setPageTransformer(true, pageTransformer)
    }

    /**
     * Set left and right padding with default value
     */
    fun setDefaultPadding(context: Activity) {
        setPercentagePadding(context, DEFAULT_PERCENTAGE_PADDING)
    }

    /**
     * Set left and right padding based on percentage of the screen width
     * If the percentage is more than 18, the left and right items height might not be consistent
     */
    fun setPercentagePadding(context: Activity, percentage: Int) {
        when {
            percentage == 0 -> initProperties(context, 0f)
            percentage < 0 -> throw IllegalArgumentException("Percentage can't be lower than 0")
            percentage > 100 -> throw IllegalArgumentException("Percentage can't be higher than 100")
            else -> {
                val metrics = DisplayMetrics()
                context.windowManager.defaultDisplay.getMetrics(metrics)
                val padding = metrics.widthPixels * percentage / 100f
                initProperties(context, padding)
            }
        }
    }

    /**
     * Set left and right padding based on dp value
     */
    fun setDpPadding(context: Activity, dp: Float) {
        val padding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.resources.displayMetrics
        )
        initProperties(context, padding)
    }

    private fun initProperties(context: Activity, padding: Float) {
        val intPadding = padding.toInt()
        setPadding(intPadding, 0, intPadding, 0)
        clipToPadding = false
        pageMargin = 0

        val metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)
        pageTransformer.paddingFactor = padding / metrics.widthPixels
    }
}