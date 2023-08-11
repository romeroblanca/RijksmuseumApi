package com.romeroblanca.rijksmuseum.domain.model.artobjectdetailsmodel

data class ArtObjectDetailModel(
    val id: String,
    val webImage: ArtObjectDetailWebImageModel,
    val label: ArtObjectDetailLabelModel
)