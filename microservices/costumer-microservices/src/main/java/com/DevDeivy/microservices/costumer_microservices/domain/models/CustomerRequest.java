package com.DevDeivy.microservices.costumer_microservices.domain.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        Long id,
        @NotNull(message = "Name is required")
        String firstName,
        @NotNull(message = "Lastname is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Email is not valid")
        String email,
        String phone,
        String address,
        String city
) {

}
