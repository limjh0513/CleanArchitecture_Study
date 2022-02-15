package kr.hs.dgsw.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.ProductRemote
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest
import javax.inject.Inject

class ProductDataSource @Inject constructor(override val remote: ProductRemote): BaseDataSource<ProductRemote>() {
    fun getAllProduct(): Single<List<ProductData>> =
        remote.getAllProduct()

    fun postProduct(request: ProductRequest): Single<ProductData> =
        remote.postProduct(request)

    fun putProduct(id: Int, request:ProductRequest): Single<ProductData> =
        remote.putProduct(id, request)

    fun deleteProduct(id: Int): Completable =
        remote.deleteProduct(id)

    fun getDetailProduct(id: Int): Single<ProductData> =
        remote.getDetailProduct(id)
}