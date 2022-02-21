package kr.hs.dgsw.storeproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.ProductDataSource
import kr.hs.dgsw.data.datasource.UserDataSource
import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.data.repository.ProductRepositoryImpl
import kr.hs.dgsw.data.repository.UserRepositoryImpl
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.repository.ProductRepository
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(dataSource: AuthDataSource): AuthRepository =
        AuthRepositoryImpl(dataSource)

    @Singleton
    @Provides
    fun provideProductRepository(dataSource :ProductDataSource): ProductRepository =
        ProductRepositoryImpl(dataSource)

    @Singleton
    @Provides
    fun provideUserRepository(dataSource: UserDataSource): UserRepository =
        UserRepositoryImpl(dataSource)


}