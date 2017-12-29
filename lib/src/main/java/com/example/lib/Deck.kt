package com.example.lib

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
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

    constructor(context: Context) : super(context) {
        setPercentagePadding(context, DEFAULT_PERCENTAGE_PADDING)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Deck)
        val percentagePaddingXml = typedArray.getInt(R.styleable.Deck_padding_percentage, Integer.MAX_VALUE)
        if (percentagePaddingXml != Integer.MAX_VALUE) {
            setPercentagePadding(context, percentagePaddingXml)
        }
        val dipPaddingXmlInPixel = typedArray.getDimensionPixelSize(R.styleable.Deck_padding_dp, Integer.MAX_VALUE)
        if (dipPaddingXmlInPixel != Integer.MAX_VALUE) {
            initProperties(context, dipPaddingXmlInPixel.toFloat())
        }
        typedArray.recycle()

        // set the default padding if no properties from XML
        if (percentagePaddingXml == Integer.MAX_VALUE && dipPaddingXmlInPixel == Integer.MAX_VALUE) {
            setPercentagePadding(context, DEFAULT_PERCENTAGE_PADDING)
        }
    }

    init {
        initView()
    }

    private fun initView() {
        setPageTransformer(true, pageTransformer)
    }

    /**
     * Set left and right padding based on percentage of the screen width
     * If the percentage is more than 18, the left and right items height might not be consistent
     */
    fun setPercentagePadding(context: Context, percentage: Int) {
        when {
            percentage == 0 -> initProperties(context, 0f)
            percentage < 0 -> throw IllegalArgumentException("Percentage can't be lower than 0")
            percentage >= 50 -> throw IllegalArgumentException("Your layout will not visible if the percentage equals or higher than 50")
            else -> {
                val padding = screenWidth(context) * percentage / 100f
                initProperties(context, padding)
            }
        }
    }

    /**
     * Set left and right padding based on dp value
     */
    fun setDpPadding(context: Context, dp: Float) {
        val padding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.resources.displayMetrics
        )
        initProperties(context, padding)
    }

    private fun initProperties(context: Context, padding: Float) {
        val intPadding = padding.toInt()
        setPadding(intPadding, 0, intPadding, 0)
        clipToPadding = false
        pageMargin = 0

        pageTransformer.paddingFactor = padding / screenWidth(context)
    }

    private fun screenWidth(context: Context): Int {
        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        return metrics.widthPixels
    }
}