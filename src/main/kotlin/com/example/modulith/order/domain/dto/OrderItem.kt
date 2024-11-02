package com.example.modulith.order.domain.dto

import java.math.BigDecimal

data class OrderItem(
    val code: String,
    val name: String,
    val price: BigDecimal,
    val quantity: Int
)
