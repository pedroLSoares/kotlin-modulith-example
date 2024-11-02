package com.example.modulith.inventory

import com.example.modulith.order.domain.events.OrderCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class InventoryManagement {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @EventListener
    fun on(event: OrderCreatedEvent) {
        logger.info("Updated inventory for product code: ${event.productId}")
    }
}