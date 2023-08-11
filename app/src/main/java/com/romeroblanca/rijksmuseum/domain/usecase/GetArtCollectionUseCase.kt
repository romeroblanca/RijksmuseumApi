package com.romeroblanca.rijksmuseum.domain.usecase

import com.romeroblanca.rijksmuseum.data.repository.ArtCollectionRepository

class GetArtCollectionUseCase(private val artCollectionRepository: ArtCollectionRepository) {
    suspend fun invoke() = artCollectionRepository.getArtCollection()
}