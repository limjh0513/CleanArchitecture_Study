package kr.hs.dgsw.domain.usecase.product

import io.reactivex.Single
import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductUseCase @Inject constructor(private val repository: ProductRepository) : BaseUseCase<Single<List<ProductData>>>(){

    override fun buildUseCaseObservable(): Single<List<ProductData>> {
        return repository.getAllProduct()
    }
}