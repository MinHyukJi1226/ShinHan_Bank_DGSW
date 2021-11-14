package com.hmj.shinhanbank.network.dto.Request

data class SendAccount(
    val money: Int,
    val fromAccount: String,
    val targetAccount: String
)
