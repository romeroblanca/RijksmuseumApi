package com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto

import com.squareup.moshi.Json

data class ArtObjectDetailsDto(
    @Json(name = "artObject") val artObject: ArtObjectDetailDto?
)