package ru.kram.galaxion.playground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

class PlaygroundViewModelFactory(
	private val width: Double,
	private val height: Double,
    private val navController: NavController
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            PlaygroundViewModel::class.java -> PlaygroundViewModel(width, height, navController) as T
            else -> error("Use another viewModel factory!")
        }
    }
}