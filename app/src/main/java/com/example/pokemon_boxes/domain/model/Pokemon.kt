package com.example.pokemon_boxes.domain.model

import java.text.SimpleDateFormat
import java.util.Date

// for easier access to the ui levels
data class Pokemon(
    val id: Int? = null,
    val name: String = "",
    val type: String = "",
    val sprite: String = "https://archives.bulbagarden.net/media/upload/9/98/Missingno_RB.png",
    val date: String? ="",
    val place: String = "",
    val game: String = "",
    val notes: String = "",
    val caught: Boolean = false,
    val dexNo: Int = 0,
)
