package com.example.services;

import com.example.entities.Customer;
import com.example.entities.dto.CustomerLoginDto;
import com.example.entities.dto.CustomerRegisterDto;
import com.example.repositories.CustomerRepository;
import com.example.utils.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper objModelMapper;
    private final HttpServletRequest request;
    private final TinkEncDec tinkEncDec;

    public Customer register(CustomerRegisterDto customerRegisterDto) {
        String newPass = tinkEncDec.encrypt( customerRegisterDto.getPassword() );
        Customer customer = objModelMapper.map(customerRegisterDto, Customer.class);
        customer.setPassword( newPass );
        return customerRepository.save(customer);
    }

    public ResponseEntity login(CustomerLoginDto customerLoginDto) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customerLoginDto.getEmail());
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            String newPass = tinkEncDec.decrypt( customer.getPassword() );
            if ( newPass.equals( customerLoginDto.getPassword() ) ) {
                request.getSession().setAttribute("user", customer);
                SecurityUtil.customerSession = customer;
                return new ResponseEntity(customer, HttpStatus.OK);
            }
        }
        Map<String, Object> mp = new LinkedHashMap<>();
        mp.put("status", false);
        mp.put("message", "Username or password fail!");
        return new ResponseEntity(mp,HttpStatus.UNAUTHORIZED);
    }
}
