package com.romeroblanca.rijksmuseum.data.mappers

import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtCollectionDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtObjectDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtObjectWebImageDto
import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtCollectionModel
import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtObjectModel
import com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel.ArtObjectWebImageModel

fun ArtCollectionDto.toArtCollectionModel() = ArtCollectionModel(
    artObjects = artObjects?.map { it.toArtObjectModel() } ?: emptyList()
)

fun ArtObjectDto.toArtObjectModel() = ArtObjectModel(
    id = id ?: "",
    objectNumber = objectNumber ?: "",
    title = title ?: "",
    principalOrFirstMaker = principalOrFirstMaker ?: "",
    webImage = (webImage?.toArtObjectWebImageModel() ?: "") as ArtObjectWebImageModel
)

fun ArtObjectWebImageDto.toArtObjectWebImageModel() = ArtObjectWebImageModel(
    url = url ?: ""
)