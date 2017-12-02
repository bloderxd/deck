package com.example.bloder.deck

/**
 * Created by bloder on 02/12/17.
 */
data class Card(
        val name: String,
        val color: Int
)

fun Any?.genCards() : List<Card> = listOf(
        Card("Blue Card", R.color.blue),
        Card("Red Card", R.color.red),
        Card("Green Card", R.color.green),
        Card("Yellow Card", R.color.yellow)
)