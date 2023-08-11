package com.romeroblanca.rijksmuseum.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.romeroblanca.rijksmuseum.BuildConfig.API_URL
import com.romeroblanca.rijksmuseum.data.datasource.DataSource
import com.romeroblanca.rijksmuseum.data.datasource.DataSourceImpl
import com.romeroblanca.rijksmuseum.data.datasource.RijksmuseumApi
import com.romeroblanca.rijksmuseum.data.repository.ArtCollectionRepository
import com.romeroblanca.rijksmuseum.data.repository.ArtCollectionRepositoryImpl

const val apiUrl = API_URL

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<ArtCollectionRepository> { ArtCollectionRepositoryImpl(get()) }

    single<DataSource> { DataSourceImpl(get()) }

    single<RijksmuseumApi> {
        getRijksmuseumApi(get())
    }

}

private fun getRijksmuseumApi(retrofit: Retrofit) =
    retrofit.create(RijksmuseumApi::class.java)