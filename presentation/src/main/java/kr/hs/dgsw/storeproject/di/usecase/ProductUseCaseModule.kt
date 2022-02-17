package kr.hs.dgsw.storeproject.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.ProductRepository
import kr.hs.dgsw.domain.usecase.product.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductUseCaseModule {

    @Singleton
    @Provides
    fun provideGetAllProductUseCase(repository: ProductRepository): GetAllProductUseCase =
        GetAllProductUseCase(repository)


    @Singleton
    @Provides
    fun providePostProductUseCase(repository: ProductRepository): PostProductUseCase =
        PostProductUseCase(repository)


    @Singleton
    @Provides
    fun providePutProductUseCase(repository: ProductRepository): PutProductUseCase =
        PutProductUseCase(repository)

    @Singleton
    @Provides
    fun provideDeleteProductUseCase(repository: ProductRepository): DeleteProductUseCase =
        DeleteProductUseCase(repository)


    @Singleton
    @Provides
    fun provideGetDetailProductUseCase(repository: ProductRepository): GetDetailProductUseCase =
        GetDetailProductUseCase(repository)
}