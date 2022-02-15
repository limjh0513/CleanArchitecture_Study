package kr.hs.dgsw.domain.model.request

data class LoginRequest(
    val email: String,
    val password: String,
)