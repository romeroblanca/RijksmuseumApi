package com.romeroblanca.rijksmuseum.domain.usecase

import com.romeroblanca.rijksmuseum.data.repository.ArtCollectionRepository
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel

class GetArtObjectDetailsUseCase(private val artCollectionRepository: ArtCollectionRepository) {
    suspend fun invoke(id: String): ArtObjectDetailsModel =
        artCollectionRepository.getArtObjectDetails(id)
}