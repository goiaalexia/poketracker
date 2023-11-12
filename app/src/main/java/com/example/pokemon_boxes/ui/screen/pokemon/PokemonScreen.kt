@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.pokemon_boxes.ui.screen.pokemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(state: PokemonState, onEvent: (PokemonEvent) -> Unit) {
    // Boolean state to track whether the delete confirmation dialog is open
    var isDeleteDialogVisible by remember { mutableStateOf(false) }

    // Function to show or hide the delete confirmation dialog
    fun toggleDeleteDialogVisibility(show: Boolean) {
        isDeleteDialogVisible = show
    }

    if (isDeleteDialogVisible) {
        AlertDialog(
            onDismissRequest = { toggleDeleteDialogVisibility(false) },
            title = { Text("Confirm Delete") },
            text = { Text("Are you sure you want to delete this Pokemon?") },
            confirmButton = {
                Button(
                    onClick = {
                        toggleDeleteDialogVisibility(false)
                        onEvent(PokemonEvent.DeletePokemon)
                    }
                ) {
                    Text("Delete")
                }
            },
            dismissButton = {
                Button(
                    onClick = { toggleDeleteDialogVisibility(false) }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

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
                IconButton(onClick = { toggleDeleteDialogVisibility(true) }) {
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
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { onEvent(PokemonEvent.NameChange(it)) },
                placeholder = { Text(text = "Pokemon Name") }
            )
            OutlinedTextField(
                value = state.sprite,
                onValueChange = { onEvent(PokemonEvent.SpriteChange(it)) },
                placeholder = { Text(text = "Sprite Link") }

            )
            OutlinedTextField(
                value = state.place,
                onValueChange = { onEvent(PokemonEvent.PlaceChange(it)) },
                placeholder = { Text(text = "Place") }
            )
            OutlinedTextField(
                value = state.game,
                onValueChange = { onEvent(PokemonEvent.GameChange(it)) },
                placeholder = { Text(text = "Game") }

            )
            OutlinedTextField(
                value = state.notes,
                onValueChange = { onEvent(PokemonEvent.NotesChange(it)) },
                placeholder = { Text(text = "Notes") }

            )
            state.date?.let { date ->
                OutlinedTextField(
                    value = date,
                    onValueChange = { onEvent(PokemonEvent.DateChange(it)) },
                    placeholder = { Text(text = "Date") }

                )
            }
            OutlinedTextField(
                value = state.type,
                onValueChange = { onEvent(PokemonEvent.TypeChange(it)) },
                placeholder = { Text(text = "Type") }

            )
            OutlinedTextField(
                value = state.dexNo.toString(),
                onValueChange = { if(it.isNotEmpty()) onEvent(PokemonEvent.DexNoChange(it.toInt())) },
                placeholder = { Text(text = "Dex Number") }

            )
            Checkbox(
                checked = state.caught,
                onCheckedChange = { onEvent(PokemonEvent.CaughtChange(it)) },
                colors = CheckboxDefaults.colors(MaterialTheme.colorScheme.primary)
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

