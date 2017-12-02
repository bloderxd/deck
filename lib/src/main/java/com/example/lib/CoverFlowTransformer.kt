package com.example.lib

import android.support.v4.view.ViewPager
import android.view.View
import android.support.v4.view.ViewCompat.setAlpha
import android.support.v4.view.ViewCompat.setScaleY
import android.support.v4.view.ViewCompat.setScaleX



/**
 * Created by bloder on 25/08/17.
 */
class CoverFlowTransformer : ViewPager.PageTransformer {

    private var SCALE_MIN = 0.3f
    private var SCALE_MAX = 1f
    private var MIN_ALPHA = 0.5f
    private var scale = .05f
    private var paddingFactor: Float = 0.08f

    fun minScale(scale: Float) : CoverFlowTransformer {
        SCALE_MIN = scale
        return this
    }

    fun maxScale(scale: Float) : CoverFlowTransformer {
        SCALE_MAX = scale
        return this
    }

    fun minAlpha(alpha: Float) : CoverFlowTransformer {
        MIN_ALPHA = alpha
        return this
    }

    fun scale(scale: Float) : CoverFlowTransformer {
        this.scale = scale
        return this
    }

    fun paddingFactor(padding: Float) : CoverFlowTransformer {
        this.paddingFactor = padding
        return this
    }

    override fun transformPage(page: View, position: Float) {
        val realPosition = position - paddingFactor
        val realScale = getFloat(1 - Math.abs(realPosition * scale), SCALE_MIN, SCALE_MAX)
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

fun Deck.with(reverseDrawingOrder: Boolean = true, init: CoverFlowTransformer.() -> CoverFlowTransformer) {
    this.setPageTransformer(reverseDrawingOrder, CoverFlowTransformer().init())
}
