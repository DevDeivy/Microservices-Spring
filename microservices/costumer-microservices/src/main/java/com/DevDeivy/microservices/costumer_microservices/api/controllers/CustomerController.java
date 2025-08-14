package com.DevDeivy.microservices.costumer_microservices.api.controllers;

import com.DevDeivy.microservices.costumer_microservices.application.services.CustomerService;
import com.DevDeivy.microservices.costumer_microservices.domain.models.Customer;
import com.DevDeivy.microservices.costumer_microservices.domain.models.CustomerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{id}")
     ResponseEntity<Object> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/customers")
    public ResponseEntity<Object> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }
}











