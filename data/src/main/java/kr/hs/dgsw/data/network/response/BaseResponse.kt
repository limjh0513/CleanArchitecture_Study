package kr.hs.dgsw.data.network.response

data class BaseResponse<T>(
    val status: Boolean,
    val message: String,
    val errors: List<String>?,
    val data: T,
)
