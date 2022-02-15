package kr.hs.dgsw.domain.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
)
