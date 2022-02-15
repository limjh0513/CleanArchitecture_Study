package kr.hs.dgsw.data.repository

import io.reactivex.Single
import kr.hs.dgsw.data.datasource.UserDataSource
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataSource: UserDataSource) :
    UserRepository {
    override fun getUser(): Single<UserData> =
        dataSource.getUser()

    override fun updateUser(request: UpdateUserRequest): Single<UserData> =
        dataSource.updateUser(request)
}