package com.romeroblanca.rijksmuseum.data.datasource

import com.romeroblanca.rijksmuseum.BuildConfig.API_KEY
import com.romeroblanca.rijksmuseum.data.datasource.dto.artcollectiondto.ArtCollectionDto
import com.romeroblanca.rijksmuseum.data.datasource.dto.artobjectdetailsdto.ArtObjectDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val apiKey: String = API_KEY

interface RijksmuseumApi {

    @GET("/api/en/collection?imgonly=True&ps=20")
    suspend fun getArtCollection(
        @Query("key") api_key: String = apiKey
    ): ArtCollectionDto

    @GET("/api/en/collection/{id}?")
    suspend fun getArtObjectDetails(
        @Path("id") id: String,
        @Query("key") api_key: String = apiKey
    ): ArtObjectDetailsDto

}


