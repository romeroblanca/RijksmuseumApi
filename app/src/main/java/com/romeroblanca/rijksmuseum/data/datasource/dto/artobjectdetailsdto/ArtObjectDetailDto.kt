package com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto

import com.squareup.moshi.Json

data class ArtObjectDetailDto(
    @Json(name = "id") val id: String?,
    @Json(name = "webImage") val webImage: ArtObjectDetailWebImageDto?,
    @Json(name = "label") val label: ArtObjectDetailLabelDto?
)