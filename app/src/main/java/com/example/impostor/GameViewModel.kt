package com.example.impostor

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlin.random.Random

class GameViewModel: ViewModel() {
    var players = mutableStateListOf<String>()
        private set
    fun updatePlayers(newPlayers: SnapshotStateList<String>) {
        players = newPlayers
    }
    fun randomizePlayerList() {
        players.shuffle()
    }
    var currPlayer by mutableStateOf<String>("")
    fun updateCurrPlayer(newCurrPlayer: String) {
        currPlayer = newCurrPlayer
    }

    var currIndex by mutableIntStateOf(0)
    fun incrementCurrIndex() {
        currIndex++
    }
    fun updateCurrIndex(updatedIndex: Int) {
        currIndex = updatedIndex
    }

    var currSecret by mutableStateOf("")
    fun updateCurrSecret(newSecret: String) {
        currSecret = newSecret
    }

    var currImpostorIndex by mutableIntStateOf(0)
    fun updateCurrImpostorIndex() {
        currImpostorIndex = Random.nextInt(players.size)
    }

    var voting = mutableMapOf<String, Int>()
    fun vote(key: String) {
        voting[key] = (voting[key]?: 0) + 1
    }

    fun resetGame() {
        currPlayer = ""
        currIndex = 0
        currSecret = ""
        voting = mutableMapOf<String, Int>()
    }
}