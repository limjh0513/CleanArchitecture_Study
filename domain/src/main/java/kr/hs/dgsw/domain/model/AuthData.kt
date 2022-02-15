package kr.hs.dgsw.domain.model

data class AuthData(
    val id: Int,
    val name: String,
    val email: String,
    val token: String,
)