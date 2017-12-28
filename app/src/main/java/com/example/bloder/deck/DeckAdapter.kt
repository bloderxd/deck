package com.example.bloder.deck

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by bloder on 02/12/17.
 */
class DeckAdapter(private val context: Context) : PagerAdapter() {

    private val cards by lazy { genCards() }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card, null)
        container?.addView(view, 0)
        view.findViewById<CardView>(R.id.card).cardBackgroundColor =
                ContextCompat.getColorStateList(context, cards[position].color)
        view.findViewById<TextView>(R.id.title).text = cards[position].name
        return view
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view == `object`
    override fun getCount(): Int = cards.size
}