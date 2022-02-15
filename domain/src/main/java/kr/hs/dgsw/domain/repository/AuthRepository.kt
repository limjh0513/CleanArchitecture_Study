package kr.hs.dgsw.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.domain.model.AuthData
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest

interface AuthRepository {
    fun register(request: RegisterRequest): Single<AuthData>

    fun login(request: LoginRequest): Single<AuthData>
}