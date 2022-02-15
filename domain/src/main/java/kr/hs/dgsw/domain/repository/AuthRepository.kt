package kr.hs.dgsw.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.LoginRequest
import kr.hs.dgsw.domain.model.request.RegisterRequest

interface AuthRepository {
    fun register(request: RegisterRequest): Single<AuthData>

    fun login(request: LoginRequest): Single<AuthData>
}