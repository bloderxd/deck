package com.example.bloder.deck

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lib.Deck

/**
 * Created by bloder on 25/08/17.
 */
class MainActivity : AppCompatActivity() {

    private val deckPager by lazy { findViewById<Deck>(R.id.deck_pager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        deckPager.offscreenPageLimit = 5
        deckPager.adapter = DeckAdapter(this)
        deckPager.useDefaultPadding(this)
    }
}