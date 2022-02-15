package kr.hs.dgsw.storeproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.network.remote.AuthRemote
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideAuthDataSource(remote: AuthRemote): AuthDataSource =
        AuthDataSource(remote)

}