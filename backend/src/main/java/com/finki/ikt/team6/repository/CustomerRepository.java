package com.finki.ikt.team6.repository;

import com.finki.ikt.team6.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}