package com.example.photogalleryapp

import com.example.photogalleryapp.network.NasaApi
import com.example.photogalleryapp.network.NasaRepository
import com.example.photogalleryapp.network.NasaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNasaApi(): NasaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(api: NasaApi): NasaRepository {
        return NasaRepositoryImpl(api)
    }
}