package kr.hs.dgsw.data.datasource

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.UserRemote
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest
import javax.inject.Inject

class UserDataSource @Inject constructor(override val remote: UserRemote) :
    BaseDataSource<UserRemote>() {
    fun getUser(): Single<UserData> = remote.getUser()

    fun updateUser(request: UpdateUserRequest): Single<UserData> = remote.updateUser(request)
}