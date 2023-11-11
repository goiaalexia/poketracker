package com.example.pokemon_boxes.ui.screen.pokemon

import android.icu.text.CaseMap.Title
import java.text.SimpleDateFormat
import java.util.Date

data class PokemonState(
    val id: Int? = null,
    val name: String = "",
    val type: String = "",
    val sprite: String = "https://archives.bulbagarden.net/media/upload/9/98/Missingno_RB.png",
    val date: String? = "",
    val place: String = "",
    val game: String = "",
    val notes: String = "",
    val caught: Boolean = false,
    val dexNo: Int = 0,
)
