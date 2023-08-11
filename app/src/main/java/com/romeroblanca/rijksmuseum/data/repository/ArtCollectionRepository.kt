package com.romeroblanca.rijksmuseum.data.repository

import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtCollectionModel
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel

interface ArtCollectionRepository {

    suspend fun getArtCollection(): ArtCollectionModel
    suspend fun getArtObjectDetails(id: String): ArtObjectDetailsModel

}