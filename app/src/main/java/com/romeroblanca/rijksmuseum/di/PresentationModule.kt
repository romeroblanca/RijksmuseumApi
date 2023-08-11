package com.romeroblanca.rijksmuseum.di

import com.romeroblanca.rijksmuseum.presentation.collection.ArtCollectionViewModel
import com.romeroblanca.rijksmuseum.presentation.details.ArtObjectDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ArtCollectionViewModel(get()) }
    viewModel { ArtObjectDetailsViewModel(get()) }
}