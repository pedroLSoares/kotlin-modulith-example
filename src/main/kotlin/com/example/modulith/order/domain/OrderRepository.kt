package com.example.modulith.order.domain

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<OrderEntity, Long>{


    fun findByOrderNumber(orderNumber: String): OrderEntity?
}