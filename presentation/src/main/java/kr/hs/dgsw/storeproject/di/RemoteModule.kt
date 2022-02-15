package kr.hs.dgsw.storeproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.service.AuthService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideAuthRemote(service: AuthService): AuthRemote =
        AuthRemote(service)
}