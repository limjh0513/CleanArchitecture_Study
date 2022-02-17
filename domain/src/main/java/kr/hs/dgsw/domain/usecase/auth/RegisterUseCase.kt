package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.model.request.RegisterRequest
import kr.hs.dgsw.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: AuthRepository): ParamsUseCase<RegisterUseCase.Params, Single<AuthData>>() {

    override fun buildUseCaseObservable(params: Params): Single<AuthData> {
        return repository.register(RegisterRequest(params.name, params.email, params.password))
    }

    data class Params(
        val name: String,
        val email: String,
        val password: String,
    )
}