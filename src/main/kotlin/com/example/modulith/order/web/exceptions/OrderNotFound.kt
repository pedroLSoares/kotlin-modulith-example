package com.example.modulith.order.web.exceptions

data class OrderNotFound(
    override val message: String
) : RuntimeException(message)
