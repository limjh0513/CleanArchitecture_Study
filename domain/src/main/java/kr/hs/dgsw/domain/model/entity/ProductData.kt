package kr.hs.dgsw.domain.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductData(
    val id: Int,
    @SerializedName("product_name")
    val name: String,
    val price: Int,
    val user: UserData,
): Serializable
