package com.example.modulith.order.domain.dto

import jakarta.persistence.Column
import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderDetailResponse(
    val orderNumber: String,
    val code: String,
    val name: String,
    val price: BigDecimal,
    val quantity: Int,
    val status: OrderStatus,
    val user: Map<String, Any?>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)