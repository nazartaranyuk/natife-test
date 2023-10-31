package com.nazartaraniuk.natifetest.presentation.main_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.nazartaraniuk.natifetest.databinding.FragmentMainBinding
import com.nazartaraniuk.natifetest.presentation.main_screen.adapter.GifsAdapter
import com.nazartaraniuk.natifetest.presentation.main_screen.main_screen_intent.MainIntent
import com.nazartaraniuk.natifetest.presentation.utils.attachLinearAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment(){

    @Inject
    lateinit var viewModel: MainFragmentViewModel
    private val adapter by lazy {
        GifsAdapter()
    }

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.attachLinearAdapter(adapter)
        viewModel.sendIntent(MainIntent.LoadGifs)
        observe()
    }

    private fun observe() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.gifsStateFlow.collect { list ->
                    adapter.submitList(list)
                }
            }
        }
    }

}