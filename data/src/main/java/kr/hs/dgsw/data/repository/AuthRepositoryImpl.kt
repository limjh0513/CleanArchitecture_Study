package kr.hs.dgsw.data.repository

import io.reactivex.Single
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.LoginRequest
import kr.hs.dgsw.domain.model.request.RegisterRequest
import kr.hs.dgsw.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val dataSource: AuthDataSource) :
    AuthRepository {
    override fun register(request: RegisterRequest): Single<AuthData> =
        dataSource.register(request)

    override fun login(request: LoginRequest): Single<AuthData> =
        dataSource.login(request)
}