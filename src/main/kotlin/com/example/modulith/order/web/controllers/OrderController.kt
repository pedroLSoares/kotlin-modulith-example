package com.example.modulith.order.web.controllers

import com.example.modulith.order.domain.OrderService
import com.example.modulith.order.domain.dto.CreateOrderRequest
import com.example.modulith.order.domain.dto.CreateOrderResponse
import com.example.modulith.order.domain.dto.OrderDetailResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    suspend fun createOrder(@Valid @RequestBody request: CreateOrderRequest): CreateOrderResponse {
        return orderService.createOrder(request)
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    suspend fun createOrder(@PathVariable("orderId") orderId: String): OrderDetailResponse {
        return orderService.getOrderDetails(orderId)
    }
}