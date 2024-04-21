package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Customer;
import com.finki.ikt.team6.model.User;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer findById(Long id);
    Customer deleteCustomer(Long id);
    Customer createCustomer(User user, String name, String surname, String emaiil, String address, int grade);
    Customer updateCustomer(Long id, User user, String name, String surname, String emaiil, String address, int grade);
}