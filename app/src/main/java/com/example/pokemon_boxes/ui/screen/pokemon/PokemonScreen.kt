package com.example.pokemon_boxes.ui.screen.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(state: PokemonState, onEvent: (PokemonEvent) -> Unit) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.sprite,
                onValueChange = { onEvent(PokemonEvent.SpriteChange(it)) }
            )
            OutlinedTextField(
                value = state.place,
                onValueChange = { onEvent(PokemonEvent.PlaceChange(it)) }
            )
            OutlinedTextField(
                value = state.game,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.notes,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.date.toString(),
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.type,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.dexNo.toString(),
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )
            OutlinedTextField(
                value = state.caught.toString(),
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) }
            )

        }
    }
}

@Composable
fun triangleShape() = GenericShape { size, _ ->
    moveTo(size.width / 2, 0f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)
    close()
}