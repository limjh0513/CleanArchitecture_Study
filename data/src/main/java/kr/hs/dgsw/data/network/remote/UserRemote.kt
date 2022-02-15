package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.UserService
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest
import javax.inject.Inject

class UserRemote @Inject constructor(override val service: UserService) :
    BaseRemote<UserService>() {
    fun getUser(): Single<UserData> =
        service.getUser().map(getResponseData())

    fun updateUser(request: UpdateUserRequest): Single<UserData> =
        service.updateUser(request).map(getResponseData())
}