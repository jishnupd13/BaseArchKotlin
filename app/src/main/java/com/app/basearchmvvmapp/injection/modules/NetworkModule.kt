package com.app.basearchmvvmapp.injection.modules

import com.app.basearchmvvmapp.data.network.albums.AlbumsApiService
import com.app.basearchmvvmapp.data.network.animals.AnimalsApiService
import com.app.basearchmvvmapp.utils.ALBUMS_BASE_URL
import com.app.basearchmvvmapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
     fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideAnimalsService(retrofit: Retrofit): AnimalsApiService =
        retrofit.create(AnimalsApiService::class.java)



    @Singleton
    @Provides
    @Named("albums")
    fun provideAlbumsRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ALBUMS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }


    @Singleton
    @Provides
    fun provideAlbumsService(
        @Named("albums")
        retrofit: Retrofit
    ): AlbumsApiService =
        retrofit.create(AlbumsApiService::class.java)

}