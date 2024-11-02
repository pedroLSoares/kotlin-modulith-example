package com.example.modulith.order.domain.events

import org.springframework.modulith.NamedInterface
import org.springframework.modulith.PackageInfo


@PackageInfo
@NamedInterface("orders-events")
data class OrderCreatedEvent(
    val orderNumber: String,
    val productId: String,
    val quantity: Int
)