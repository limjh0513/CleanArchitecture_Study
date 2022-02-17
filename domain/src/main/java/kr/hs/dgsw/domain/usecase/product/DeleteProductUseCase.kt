package kr.hs.dgsw.domain.usecase.product

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.ProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(private val repository: ProductRepository): ParamsUseCase<DeleteProductUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return repository.deleteProduct(params.id)
    }

    data class Params(
        val id: Int,
    )

}