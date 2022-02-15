package kr.hs.dgsw.data.network.remote

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.ProductService
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest
import javax.inject.Inject

class ProductRemote @Inject constructor(override val service: ProductService): BaseRemote<ProductService>() {
    fun getAllProduct(): Single<List<ProductData>> =
        service.getAllProduct().map(getResponseData())

    fun postProduct(request: ProductRequest): Single<ProductData> =
        service.postProduct(request).map(getResponseData())

    fun putProduct(id: Int, request: ProductRequest): Single<ProductData> =
        service.putProduct(id, request).map(getResponseData())

    fun deleteProduct(id: Int): Completable =
        service.deleteProduct(id).map(getResponseMessage()).ignoreElement()

    fun getDetailProduct(id: Int): Single<ProductData> =
        service.getDetailProduct(id).map(getResponseData())
}