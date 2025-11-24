package com.sena.practica_de_consumo_api.di

import com.sena.practica_de_consumo_api.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(value = SingletonComponent::class)
object RepositoryModule {
    @Provides

    fun providePokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl)
    : PokemonRepository{
        return pokemonRepositoryImpl
    }


}