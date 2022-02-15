package kr.hs.dgsw.data.datasource

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.model.AuthData
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import javax.inject.Inject

class AuthDataSource @Inject constructor(override val remote: AuthRemote) : BaseDataSource<AuthRemote>() {
    fun register(request: RegisterRequest): Single<AuthData> = remote.postRegister(request)

    fun login(request: LoginRequest): Single<AuthData> = remote.postLogin(request)
}