package com.DevDeivy.microservices.costumer_microservices.infraestructure.repository;

import com.DevDeivy.microservices.costumer_microservices.domain.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
