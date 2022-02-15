package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.LoginRequest
import kr.hs.dgsw.domain.model.request.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/register")
    fun register(@Body request: RegisterRequest): Single<Response<BaseResponse<AuthData>>>

    @POST("auth/login")
    fun login(@Body request: LoginRequest): Single<Response<BaseResponse<AuthData>>>
}