package com.DevDeivy.microservices.costumer_microservices.application.services;

import com.DevDeivy.microservices.costumer_microservices.domain.models.Customer;
import com.DevDeivy.microservices.costumer_microservices.domain.models.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperService {

    public Customer toCustomer(CustomerRequest request){
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .build();
    }
}
