package com.example.repositories;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);
    Optional<Customer> findByEmailEqualsIgnoreCase(String email);
}