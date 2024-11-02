package com.example.modulith.order.domain

import com.example.modulith.order.domain.dto.CreateOrderRequest
import com.example.modulith.order.domain.dto.CreateOrderResponse
import com.example.modulith.order.domain.dto.OrderDetailResponse
import com.example.modulith.order.domain.events.OrderCreatedEvent
import com.example.modulith.order.web.exceptions.OrderNotFound
import com.example.modulith.order.web.gateway.CustomerGateway
import org.jboss.logging.Logger
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val customerGateway: CustomerGateway
) {

    private val logger = Logger.getLogger(this.javaClass)

    suspend fun createOrder(request: CreateOrderRequest): CreateOrderResponse {
        val newOrder = request.toOrderEntity()
        val savedOrder = orderRepository.save(newOrder)
        logger.info("Created Order with orderNumber=${savedOrder.orderNumber}")

        val creationEvent = OrderCreatedEvent(
            orderNumber = savedOrder.orderNumber,
            productId = savedOrder.code,
            quantity = savedOrder.quantity
        )

        applicationEventPublisher.publishEvent(creationEvent)

        return CreateOrderResponse(savedOrder.orderNumber)
    }

    suspend fun getOrderDetails(orderNumber: String): OrderDetailResponse {
        val orderDetail = orderRepository.findByOrderNumber(orderNumber) ?:
        throw OrderNotFound("order $orderNumber not found")

        val userInfo = customerGateway.getCustomer(orderDetail.customerId)

        return OrderDetailResponse(
            orderNumber = orderNumber,
            code = orderDetail.code,
            name = orderDetail.name,
            price = orderDetail.price,
            quantity = orderDetail.quantity,
            status = orderDetail.status,
            user = userInfo,
            createdAt = orderDetail.createdAt,
            updatedAt = orderDetail.updatedAt
        )
    }
}