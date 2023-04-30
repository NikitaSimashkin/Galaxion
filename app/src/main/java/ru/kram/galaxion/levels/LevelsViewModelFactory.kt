package ru.kram.galaxion.levels;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

class LevelsViewModelFactory(
	private val navController: NavController
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return when (modelClass) {
			LevelsViewModel::class.java -> LevelsViewModel(navController) as T
			else -> error("Use another viewModel factory!")
		}
	}
}
