package kr.hs.dgsw.domain.model.entity

import java.io.Serializable

data class UserData(
    val id: Int,
    val name: String,
    val email: String,
): Serializable
