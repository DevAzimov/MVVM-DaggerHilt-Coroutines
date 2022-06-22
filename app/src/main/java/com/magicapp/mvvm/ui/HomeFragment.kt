package com.magicapp.mvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.magicapp.mvvm.R
import com.magicapp.mvvm.data.local.entity.News
import com.magicapp.mvvm.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val news = News(id = 1,title = "", description = "", image = "")
        viewModel.addNews(news)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.newsState.collect {
                    when(it){
                        is UiStateObject.LOADING -> {
                            //loading progress show
                        }
                        is UiStateObject.SUCCESS -> {
                            //adapterga listni bervoramiz
                            Toast.makeText(requireContext(), it.data.description, Toast.LENGTH_SHORT).show()
                        }
                        is UiStateObject.ERROR -> {
                            //show error like
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}