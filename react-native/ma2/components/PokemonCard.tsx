// Placeholder implementation for the Pokemon card
// You can customize the card design as needed
import React from 'react';
import { View, Text, TouchableOpacity, Image } from 'react-native';
import { Pokemon } from '../models/Pokemon';

const PokemonCard: React.FC<{ pokemon: Pokemon, onPress: () => void }> = ({ pokemon, onPress }) => {
    return (
        <TouchableOpacity onPress={onPress}>
            <View>
                <Image source={{ uri: pokemon.sprite }} style={{ width: 100, height: 100 }} />
                <Text>{pokemon.name}</Text>
                <Text>Type: {pokemon.type}</Text>
            </View>
        </TouchableOpacity>
    );
};

export default PokemonCard;
