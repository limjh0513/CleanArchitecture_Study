package kr.hs.dgsw.domain.repository

import io.reactivex.Single
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest

interface UserRepository {
    fun getUser(): Single<UserData>

    fun updateUser(request: UpdateUserRequest): Single<UserData>
}