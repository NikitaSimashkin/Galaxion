package ru.kram.galaxion.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

class MainMenuViewModelFactory(
    private val mainMenuNavController: NavController
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainMenuViewModel::class.java -> MainMenuViewModel(mainMenuNavController) as T
            else -> error("Use another viewModel factory!")
        }
    }
}