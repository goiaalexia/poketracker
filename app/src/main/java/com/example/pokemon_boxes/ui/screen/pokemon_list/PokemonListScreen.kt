@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pokemon_boxes.ui.screen.pokemon_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokemon_boxes.domain.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    pokemonList: List<Pokemon>,
    onPokemonClick: (Pokemon) -> Unit,
    onAddPokemonClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddPokemonClick) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Pokemon")

            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 15.dp + padding.calculateTopPadding(),
                bottom = 15.dp + padding.calculateBottomPadding()
            )
        ) {
            item { Text(text = "Pokemon Boxes", style = MaterialTheme.typography.titleLarge) }
            items(pokemonList) { pokemon ->
                ListItem(
                    headlineText = {
                        Text(text = pokemon.name, style = MaterialTheme.typography.titleMedium)
                    },
                    supportingText = {
                        Text(
                            text = (pokemon.type)
                        )
                    },
                    modifier = Modifier.clickable(onClick = { onPokemonClick(pokemon) })
                )
            }
        }
    }
}