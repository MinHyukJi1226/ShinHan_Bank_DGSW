package com.hmj.shinhanbank.network.dto.Request

data class SignUpRequest(
    val id: String,
    val pw: String,
    val phonenum: String,
    val birth: String,
    val name: String,
    val nickname: String,
)
