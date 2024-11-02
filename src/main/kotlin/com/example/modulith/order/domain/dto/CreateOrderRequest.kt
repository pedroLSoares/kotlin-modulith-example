package com.example.modulith.order.domain.dto

import com.example.modulith.order.domain.OrderEntity
import jakarta.validation.Valid
import java.util.UUID

data class CreateOrderRequest(
    @Valid val item: OrderItem,
    @Valid val customerId: String
) {
    fun toOrderEntity(): OrderEntity {
        return OrderEntity(
            name = item.name,
            code = item.code,
            orderNumber = UUID.randomUUID().toString(),
            status = OrderStatus.NEW,
            customerId = customerId,
            price = item.price,
            quantity = item.quantity
        )
    }
}