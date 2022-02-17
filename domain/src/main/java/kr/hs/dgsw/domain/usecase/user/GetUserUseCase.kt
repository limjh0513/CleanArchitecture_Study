package kr.hs.dgsw.domain.usecase.user

import io.reactivex.Single
import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository): BaseUseCase<Single<UserData>>() {
    override fun buildUseCaseObservable(): Single<UserData> {
        return repository.getUser()
    }
}