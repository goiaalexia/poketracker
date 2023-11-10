package com.example.pokemon_boxes.domain.model

import java.text.SimpleDateFormat
import java.util.Date

// for easier access to the ui levels
data class Pokemon(
    val id: Int? = null,
    val name: String = "",
    val type: String = "",
    val atk: Boolean = false,
    val hp: Boolean = false,
    val def: Boolean = false,
    val spAtk: Boolean = false,
    val spDef: Boolean = false,
    val spd: Boolean = false,
    val sprite: String = "https://archives.bulbagarden.net/media/upload/9/98/Missingno_RB.png",
    val date: Date? = SimpleDateFormat("DD/MM/YYYY").parse("01/01/1970"),
    val place: String = "",
    val game: String = "",
    val notes: String = "",
    val caught: Boolean = false,
    val dexNo: Int = 0,
)
