package com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto

import com.squareup.moshi.Json

data class ArtObjectDetailWebImageDto(
    @Json(name = "url") val url: String?
)