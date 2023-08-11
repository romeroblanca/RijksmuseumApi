package com.romeroblanca.rijksmuseum.data.mappers

import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailLabelDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailWebImageDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailsDto
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailLabelModel
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailModel
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailWebImageModel
import com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel.ArtObjectDetailsModel

fun ArtObjectDetailsDto.toArtObjectDetailsModel() = ArtObjectDetailsModel(
    artObject = (artObject?.toArtObjectDetailModel() ?: "") as ArtObjectDetailModel
)

fun ArtObjectDetailDto.toArtObjectDetailModel() = ArtObjectDetailModel(
    id = id ?: "",
    label = (label?.toArtObjectDetailLabelModel() ?: "") as ArtObjectDetailLabelModel,
    webImage = (webImage?.toArtObjectDetailWebImageModel() ?: "") as ArtObjectDetailWebImageModel
)

fun ArtObjectDetailWebImageDto.toArtObjectDetailWebImageModel() = ArtObjectDetailWebImageModel(
    url = url ?: ""
)

fun ArtObjectDetailLabelDto.toArtObjectDetailLabelModel() = ArtObjectDetailLabelModel(
    title = title ?: "",
    makerLine = makerLine ?: "",
    description = description ?: ""
)
