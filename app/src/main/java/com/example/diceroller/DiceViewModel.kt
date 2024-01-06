package com.example.diceroller

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DiceViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DiceUiState(R.drawable.dice_1))
    val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()

    init {
        Log.d("View Model", "init Called !")
        Logic()
    }

    fun Logic() {
        Log.d("View Model", "Button Clicked !")
        val random = (1..6).random()
        val resource = when (random) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        _uiState.update { diceUiState ->
            diceUiState.copy(
                imageResource = resource
            )
        }
    }
}