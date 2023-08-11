package com.romeroblanca.rijksmuseum.data.datasource

import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtCollectionDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailsDto

class DataSourceImpl(
    private val rijksmuseumApi: RijksmuseumApi
) : DataSource {

    override suspend fun getArtCollection(): ArtCollectionDto =
        rijksmuseumApi.getArtCollection()

    override suspend fun getArtObjectDetails(id: String): ArtObjectDetailsDto =
        rijksmuseumApi.getArtObjectDetails(id)

}