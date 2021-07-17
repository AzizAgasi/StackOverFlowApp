package com.techdot.stackoverflowapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techdot.stackoverflowapp.databinding.ActivityMainBinding

class MainViewModelFactory(binding: ActivityMainBinding): ViewModelProvider.Factory {

    private val binding = binding

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(binding) as T
    }
}