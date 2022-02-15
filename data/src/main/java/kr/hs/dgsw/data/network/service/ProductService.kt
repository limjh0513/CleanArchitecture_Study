package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.model.request.ProductRequest
import retrofit2.Response
import retrofit2.http.*

interface ProductService {
    @GET("product")
    fun getAllProduct(): Single<Response<BaseResponse<List<ProductData>>>>

    @POST("product")
    fun postProduct(@Body request: ProductRequest): Single<Response<BaseResponse<ProductData>>>

    @PUT("product/{id}")
    fun putProduct(@Path("id") id: Int, @Body request: ProductRequest): Single<Response<BaseResponse<ProductData>>>

    @DELETE("product/{id}")
    fun deleteProduct(@Path("id") id: Int): Single<Response<BaseResponse<Any>>>

    @GET("product/{id}")
    fun getDetailProduct(@Path("id") id: Int): Single<Response<BaseResponse<ProductData>>>
}