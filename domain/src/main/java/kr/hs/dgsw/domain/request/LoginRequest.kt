package kr.hs.dgsw.domain.request

data class LoginRequest(
    val email: String,
    val password: String,
)