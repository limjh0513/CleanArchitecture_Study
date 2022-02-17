package kr.hs.dgsw.storeproject.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.usecase.user.GetUserUseCase
import kr.hs.dgsw.domain.usecase.user.UpdateUserUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {
    @Singleton
    @Provides
    fun provideGetUserUseCase(repository: UserRepository): GetUserUseCase =
        GetUserUseCase(repository)

    @Singleton
    @Provides
    fun provideUpdateUserUseCase(repository: UserRepository): UpdateUserUseCase =
        UpdateUserUseCase(repository)
}