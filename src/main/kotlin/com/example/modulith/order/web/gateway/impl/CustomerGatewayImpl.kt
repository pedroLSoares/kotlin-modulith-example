package com.example.modulith.order.web.gateway.impl

import com.example.modulith.customers.CustomerService
import com.example.modulith.order.web.gateway.CustomerGateway
import org.springframework.stereotype.Component

@Component
class CustomerGatewayImpl(
    private val customerService: CustomerService
) : CustomerGateway {

    override fun getCustomer(customerId: String): Map<String, Any?> {
        return customerService.getCustomerData(customerId = customerId)
    }


}