package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface UserService {
    @GET("user/profile")
    fun getUser(): Single<Response<BaseResponse<UserData>>>

    @PUT("user/profile")
    fun updateUser(@Body request: UpdateUserRequest): Single<Response<BaseResponse<UserData>>>
}