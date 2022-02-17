package kr.hs.dgsw.domain.usecase.product

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.repository.ProductRepository
import javax.inject.Inject

class GetDetailProductUseCase @Inject constructor(private val repository: ProductRepository) : ParamsUseCase<GetDetailProductUseCase.Params, Single<ProductData>>() {

    override fun buildUseCaseObservable(params: Params): Single<ProductData> {
        return repository.getDetailProduct(params.id)
    }

    data class Params(
        val id: Int,
    )
}