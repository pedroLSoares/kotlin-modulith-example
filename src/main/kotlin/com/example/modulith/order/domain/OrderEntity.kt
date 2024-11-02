package com.example.modulith.order.domain

import com.example.modulith.order.domain.dto.OrderStatus
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_generator")
    @SequenceGenerator(name = "order_id_generator", sequenceName = "order_id_seq")
    val id: Long? = null,
    val orderNumber: String,
    val customerId: String,
    val code: String,
    val name: String,
    val price: BigDecimal,
    val quantity: Int,
    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),

)