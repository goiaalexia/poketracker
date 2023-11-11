@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.pokemon_boxes.ui.screen.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokemonScreen(state: PokemonState, onEvent: (PokemonEvent) -> Unit) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {},
            navigationIcon = {
                IconButton(
                    onClick = { onEvent(PokemonEvent.NavigateBack) }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Navigate Back"
                    )

                }
            }, actions = {
                IconButton(onClick = { onEvent(PokemonEvent.DeletePokemon) }) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete"
                    )
                }
            })
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "Missingno") }
            )
            OutlinedTextField(
                value = state.sprite,
                onValueChange = { onEvent(PokemonEvent.SpriteChange(it)) },
                placeholder = { Text(text = "https://archives.bulbagarden.net/media/upload/9/98/Missingno_RB.png") }

            )
            OutlinedTextField(
                value = state.place,
                onValueChange = { onEvent(PokemonEvent.PlaceChange(it)) },
                placeholder = { Text(text = "") }
            )
            OutlinedTextField(
                value = state.game,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "") }

            )
            OutlinedTextField(
                value = state.notes,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "") }

            )
            state.date?.let { date ->
                OutlinedTextField(
                    value = date,
                    onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                    placeholder = { Text(text = "01/01/1970") }

                )
            }
            OutlinedTextField(
                value = state.type,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "???") }

            )
            OutlinedTextField(
                value = state.dexNo.toString(),
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "0") }

            )
            OutlinedTextField(
                value = state.caught.toString(),
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "false") }
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { onEvent(PokemonEvent.Save) },
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "Save")
                }
            }

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