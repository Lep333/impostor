package com.example.impostor

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class GameViewModel: ViewModel() {
    var players by mutableStateOf<List<String>>(emptyList<String>())
        private set

    fun updatePlayers(newPlayers: List<String>) {
        players = newPlayers
    }

    var currPlayer by mutableStateOf<String>("")

    fun updateCurrPlayer(newCurrPlayer: String) {
        currPlayer = newCurrPlayer
    }

    var currIndex by mutableIntStateOf(0)

    fun incrementCurrIndex() {
        currIndex++
    }
}