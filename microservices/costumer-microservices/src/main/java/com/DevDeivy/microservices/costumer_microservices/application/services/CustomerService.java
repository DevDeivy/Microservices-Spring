package com.DevDeivy.microservices.costumer_microservices.application.services;

import com.DevDeivy.microservices.costumer_microservices.domain.models.Customer;
import com.DevDeivy.microservices.costumer_microservices.domain.models.CustomerRequest;
import com.DevDeivy.microservices.costumer_microservices.exceptions.CustomerNotFoundException;
import com.DevDeivy.microservices.costumer_microservices.infraestructure.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperService customerMapper;

    public ResponseEntity<Object> createCustomer (CustomerRequest request){
        if(customerRepository.existsById(request.id())){
            return ResponseEntity.badRequest().body("this id exist");
        }
        var customer = customerMapper.toCustomer(request);
        Object customerSaved = customerRepository.save(customer);
        return ResponseEntity.ok(customerSaved);
    }

    public ResponseEntity<Object> getCustomerById(Long id){

        if (id == null){
            return ResponseEntity.badRequest().body("the id are not null");
        } else if (!customerRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the id was not found");
        }

        Optional<Customer> entityOptional = customerRepository.findById(id);
        return ResponseEntity.ok(entityOptional.orElseThrow(() -> new CustomerNotFoundException(
                String.format("customer with this id is not found" , id)
        )));
    }

    public ResponseEntity<Object> getAllCustomers(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    public ResponseEntity<Object> deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)){
            throw new IllegalArgumentException("this id is not found" + id);
        }
        customerRepository.deleteById(id);
        return ResponseEntity.ok("customer deleted " + id);
    }

    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid Customer customer) {
        Long id = customer.getId();
        if(id == null){
            ResponseEntity.badRequest().body("the id are not null");
        } else if (!customerRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("the client was not found");
        }
        Customer updated = customerRepository.save(customer);
        return ResponseEntity.ok(updated);
    }
}




















