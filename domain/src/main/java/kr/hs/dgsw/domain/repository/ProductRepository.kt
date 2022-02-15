package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest

interface ProductRepository {
    fun getAllProduct(): Single<List<ProductData>>

    fun postProduct(request: ProductRequest): Single<ProductData>

    fun putProduct(id: Int, request: ProductRequest): Single<ProductData>

    fun deleteProduct(id: Int): Completable

    fun getDetailProduct(id: Int): Single<ProductData>
}