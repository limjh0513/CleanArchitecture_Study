package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.LoginRequest
import kr.hs.dgsw.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository): ParamsUseCase<LoginUseCase.Params, Single<AuthData>>() {

    override fun buildUseCaseObservable(params: Params): Single<AuthData> {
        return repository.login(LoginRequest(params.email, params.password))
    }

    data class Params(
        val email: String,
        val password: String
    )
}