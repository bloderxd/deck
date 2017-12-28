package com.example.lib

import android.support.v4.view.ViewPager
import android.view.View


/**
 * Created by bloder on 25/08/17.
 */
private const val SCALE_MIN = .3f
private const val SCALE_MAX = 1f
private const val MIN_ALPHA = .5f
private const val SCALE = .05f

class CoverFlowTransformer : ViewPager.PageTransformer {

    var paddingFactor: Float = 0.08f

    override fun transformPage(page: View, position: Float) {
        val realPosition = position - paddingFactor
        val realScale = getFloat(1 - Math.abs(realPosition * SCALE), SCALE_MIN, SCALE_MAX)
        page.scaleX = realScale
        page.scaleY = realScale
        if (realPosition != 0f) {
            val scaleFactor = Math.max(SCALE_MIN, 1 - Math.abs(realPosition))
            page.alpha = MIN_ALPHA + (scaleFactor - SCALE_MIN) / (1 - SCALE_MIN) * (1 - MIN_ALPHA)
        }
    }

    private fun getFloat(value: Float, minValue: Float, maxValue: Float): Float {
        return Math.min(maxValue, Math.max(minValue, value))
    }
}