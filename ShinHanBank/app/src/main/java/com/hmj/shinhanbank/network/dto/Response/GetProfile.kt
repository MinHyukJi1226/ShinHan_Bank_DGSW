package com.hmj.shinhanbank.network.dto.Response

data class GetProfile(
    val phonenum: String,
    val birth: String,
    val name: String,
    val nickname: String
)
