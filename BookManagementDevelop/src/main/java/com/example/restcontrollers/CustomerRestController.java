package com.example.restcontrollers;

import com.example.entities.Customer;
import com.example.entities.dto.CustomerLoginDto;
import com.example.entities.dto.CustomerRegisterDto;
import com.example.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@Tag(name = "Customer Rest Controller", description = "Customer Manager")
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("register")
    public Customer register(@Valid @RequestBody CustomerRegisterDto customerRegisterDto){
        return customerService.register(customerRegisterDto);
    }

    @PostMapping("login")
    public ResponseEntity login(@Valid @RequestBody CustomerLoginDto customerLoginDto){
        return customerService.login(customerLoginDto);
    }
}
