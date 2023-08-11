package com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto

import com.squareup.moshi.Json

data class ArtObjectWebImageDto(
    @Json(name = "url") val url: String?
)