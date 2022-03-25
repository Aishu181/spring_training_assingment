package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
