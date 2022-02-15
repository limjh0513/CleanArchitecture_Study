package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.datasource.ProductDataSource
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest
import kr.hs.dgsw.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val dataSource: ProductDataSource): ProductRepository {
    override fun getAllProduct(): Single<List<ProductData>> =
        dataSource.getAllProduct()

    override fun postProduct(request: ProductRequest): Single<ProductData> =
        dataSource.postProduct(request)

    override fun putProduct(id: Int, request: ProductRequest): Single<ProductData> =
        dataSource.putProduct(id, request)

    override fun deleteProduct(id: Int): Completable =
        dataSource.deleteProduct(id)

    override fun getDetailProduct(id: Int): Single<ProductData> =
        dataSource.getDetailProduct(id)
}