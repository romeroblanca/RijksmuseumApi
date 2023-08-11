package com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto

import com.squareup.moshi.Json

data class ArtObjectDto(
    @Json(name = "id") val id: String?,
    @Json(name = "objectNumber") val objectNumber: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "principalOrFirstMaker") val principalOrFirstMaker: String?,
    @Json(name = "webImage") val webImage: ArtObjectWebImageDto?
)