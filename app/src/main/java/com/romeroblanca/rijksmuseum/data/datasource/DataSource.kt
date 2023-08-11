package com.romeroblanca.rijksmuseum.data.datasource

import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtCollectionDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailsDto

interface DataSource {
    suspend fun getArtCollection(): ArtCollectionDto
    suspend fun getArtObjectDetails(id: String): ArtObjectDetailsDto
}