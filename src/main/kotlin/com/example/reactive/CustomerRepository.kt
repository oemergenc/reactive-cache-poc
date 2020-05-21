package com.example.reactive

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class CustomerRepository(val service: CustomerService) {

    fun getCustomers(): Flux<String> {
        return service.customers()
                .switchIfEmpty(service.customersIfEmpty())
    }

    fun getDeferCustomers(): Flux<String> {
        return service.customers()
                .switchIfEmpty(Flux.defer {
                    service.customersIfEmpty()
                })
    }
}
