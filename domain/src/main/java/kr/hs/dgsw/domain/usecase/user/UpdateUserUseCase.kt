package kr.hs.dgsw.domain.usecase.user

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.model.request.UpdateUserRequest
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val repository: UserRepository) : ParamsUseCase<UpdateUserUseCase.Params, Single<UserData>>() {
    override fun buildUseCaseObservable(params: Params): Single<UserData> {
        return repository.updateUser(UpdateUserRequest(params.name, params.email))
    }

    data class Params(
        val name: String,
        val email: String,
    )
}