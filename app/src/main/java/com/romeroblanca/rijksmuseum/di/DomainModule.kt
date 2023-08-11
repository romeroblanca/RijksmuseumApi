package com.romeroblanca.rijksmuseum.di

import org.koin.dsl.module
import com.romeroblanca.rijksmuseum.domain.usecase.GetArtCollectionUseCase
import com.romeroblanca.rijksmuseum.domain.usecase.GetArtObjectDetailsUseCase

val domainModule = module {
    single { GetArtCollectionUseCase(get()) }
    single { GetArtObjectDetailsUseCase(get()) }
}