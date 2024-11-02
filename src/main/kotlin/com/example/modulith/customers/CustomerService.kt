package com.example.modulith.customers

import org.springframework.stereotype.Service

@Service
class CustomerService {

    fun getCustomerData(customerId: String): Map<String, String> {
        return mapOf(
            "id" to customerId,
            "name" to "mock-name"
        )
    }
}