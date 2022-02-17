package kr.hs.dgsw.domain.usecase.product

import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest
import kr.hs.dgsw.domain.repository.ProductRepository
import javax.inject.Inject

class PostProductUseCase @Inject constructor(private val repository: ProductRepository) : ParamsUseCase<PostProductUseCase.Params, Single<ProductData>>(){

    override fun buildUseCaseObservable(params: Params): Single<ProductData> {
        return repository.postProduct(ProductRequest(params.name, params.price))
    }

    data class Params(
        val name: String,
        val price: Int,
    )
}