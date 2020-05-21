package com.example.reactive

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class CustomerService {

    fun customers(): Flux<String> {
        val asList = listOf("sching", "schang", "schong")
        return Flux.fromIterable(asList)
    }

    fun customersIfEmpty(): Flux<String> {
        val asList = listOf("tick", "trick", "track")
        return Flux.fromIterable(asList)
    }
}



