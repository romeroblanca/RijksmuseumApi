package com.romeroblanca.rijksmuseum.domain.model.artcollectionmodel

data class ArtObjectModel(
    val id: String,
    val objectNumber: String,
    val title: String,
    val principalOrFirstMaker: String,
    val webImage: ArtObjectWebImageModel
)