package com.sena.practica_de_consumo_api.data.repository

import com.sena.practica_de_consumo_api.data.remote.dto.PokemonLisResponseDto
import retrofit2.http.GET

interface PokemonApi {


    @GET( "pokemon" )
    suspend fun getPokemons(): PokemonLisResponseDto
}