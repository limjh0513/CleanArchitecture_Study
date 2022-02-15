package kr.hs.dgsw.storeproject.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.interceptor.TokenInterceptor
import kr.hs.dgsw.data.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(application: Application, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(TokenInterceptor(application)).addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create() as CallAdapter.Factory

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create() as Converter.Factory

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, callAdapter: CallAdapter.Factory, converter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.SERVER_HOST)
            .client(okHttpClient)
            .addConverterFactory(converter)
            .addCallAdapterFactory(callAdapter)
            .build()
}