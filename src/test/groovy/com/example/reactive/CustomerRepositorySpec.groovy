package com.example.reactive

import reactor.core.publisher.Flux
import spock.lang.Specification

class CustomerRepositorySpec extends Specification {

    def customerService = Mock(CustomerService)
    def repository = new CustomerRepository(customerService)

    def "should not call customersIfEmpty but fails due to calling customersIfEmpty"() {
        given:
        customerService.customers() >> Flux.fromIterable(["hi", "iam", "not", "empty"])

        when:
        repository.getCustomers()

        then:
        0 * customerService.customersIfEmpty()
    }

    def "should not call customersIfEmpty"() {
        given:
        customerService.customers() >> Flux.fromIterable(["hi", "iam", "not", "empty"])

        when:
        repository.getDeferCustomers()

        then:
        0 * customerService.customersIfEmpty()
    }
}
