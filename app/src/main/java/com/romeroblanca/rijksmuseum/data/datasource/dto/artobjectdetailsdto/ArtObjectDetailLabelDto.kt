package com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto

import com.squareup.moshi.Json

data class ArtObjectDetailLabelDto(
    @Json(name = "title") val title: String?,
    @Json(name = "makerLine") val makerLine: String?,
    @Json(name = "description") val description: String?
)