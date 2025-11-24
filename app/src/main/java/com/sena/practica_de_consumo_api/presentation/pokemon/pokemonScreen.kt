package com.sena.practica_de_consumo_api.presentation.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.util.copy
import com.sena.practica_de_consumo_api.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(value = PokemonUiState())
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()
    init {

        loadPokemons()
    }
    fun loadPokemons(){
    viewModelScope.launch {
        _uiState.value = _uiState.value.copy(
        isLoading = true,
        errorMessage = null
        )
        try {
            val pokemons = getPokemonUseCase()
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                pokemons = pokemons,
                errorMessage = null
            )
        }catch (e : Exception){
            e.printStackTrace()
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = e.message ?: "Ocurrio un error al carga los pokemon"
            )
        }
    }
    }
}
