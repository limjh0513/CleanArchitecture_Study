package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.LoginRequest
import kr.hs.dgsw.domain.model.request.RegisterRequest
import javax.inject.Inject

class AuthRemote @Inject constructor(override val service: AuthService) :
    BaseRemote<AuthService>() {
    fun postRegister(request: RegisterRequest): Single<AuthData> =
        service.register(request).map(getResponseData())

    fun postLogin(request: LoginRequest): Single<AuthData> =
        service.login(request).map(getResponseData())
}