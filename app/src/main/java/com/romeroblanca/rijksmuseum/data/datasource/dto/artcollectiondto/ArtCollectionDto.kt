package com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto

import com.squareup.moshi.Json

data class ArtCollectionDto(
    @Json(name = "artObjects") val artObjects: List<ArtObjectDto>?
)