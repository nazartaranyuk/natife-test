package com.nazartaraniuk.natifetest.presentation.main_screen.main_screen_intent

sealed class MainIntent {

    data object LoadGifs : MainIntent()
}