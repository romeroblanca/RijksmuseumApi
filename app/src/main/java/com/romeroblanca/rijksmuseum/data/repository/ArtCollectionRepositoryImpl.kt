package com.romeroblanca.rijksmuseum.data.repository

import com.romeroblanca.rijksmuseum.data.datasource.DataSource
import com.romeroblanca.rijksmuseum.data.mappers.toArtCollectionModel
import com.romeroblanca.rijksmuseum.data.mappers.toArtObjectDetailsModel
import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtCollectionModel
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel

class ArtCollectionRepositoryImpl(
    private val dataSource: DataSource
) : ArtCollectionRepository {

    override suspend fun getArtCollection(): ArtCollectionModel {
        val data = dataSource.getArtCollection()
        data.artObjects?.filter {
            (it.id?.isNotEmpty() == true) && (it.title?.isNotEmpty() == true)
        }
        return data.toArtCollectionModel()
    }

    override suspend fun getArtObjectDetails(id: String): ArtObjectDetailsModel {
        val data = dataSource.getArtObjectDetails(id)
        return data.toArtObjectDetailsModel()
    }

}