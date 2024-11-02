package com.example.modulith.order.web.gateway

interface CustomerGateway {

    fun getCustomer(customerId: String): Map<String, Any?>
}