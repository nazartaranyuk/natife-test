package com.nazartaraniuk.natifetest.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazartaraniuk.natifetest.data.model.Data
import com.nazartaraniuk.natifetest.domain.use_case.LoadGifsUseCase
import com.nazartaraniuk.natifetest.presentation.main_screen.main_screen_intent.MainIntent
import com.nazartaraniuk.natifetest.presentation.utils.NetworkCheck
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val loadGifsUseCase: LoadGifsUseCase,
    private val networkCheck: NetworkCheck
) : ViewModel() {

    private val _gifsStateFlow = MutableStateFlow<List<Data>>(emptyList())
    val gifsStateFlow: StateFlow<List<Data>> get() = _gifsStateFlow

    fun sendIntent(intent: MainIntent) {
        when(intent) {
            is MainIntent.LoadGifs -> {
                loadGifs()
            }
        }
    }

    private fun loadGifs() {
        if (networkCheck.isOnline) {
            loadGifsRemote()
        } else {
            loadCachedGifs()
        }
    }

    private fun loadCachedGifs() = viewModelScope.launch {

    }

    private fun loadGifsRemote() = viewModelScope.launch {
        loadGifsUseCase().collect { result ->
            result
                .onSuccess {
                    _gifsStateFlow.emit(it.data)
                }
                .onFailure {
                    // TODO make here error handling
                }
        }
    }

}