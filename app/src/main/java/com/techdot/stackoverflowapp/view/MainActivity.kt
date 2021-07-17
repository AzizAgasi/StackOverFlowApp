package com.techdot.stackoverflowapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.techdot.stackoverflowapp.R
import com.techdot.stackoverflowapp.adapter.QuestionsAdapter
import com.techdot.stackoverflowapp.databinding.ActivityMainBinding
import com.techdot.stackoverflowapp.model.Question
import com.techdot.stackoverflowapp.viewModel.MainViewModel
import com.techdot.stackoverflowapp.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, MainViewModelFactory(binding)).get(MainViewModel::class.java)

        setContentView(binding.root)
    }
}