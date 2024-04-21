package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Customer;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.exceptions.InvalidCustomerIdException;
import com.finki.ikt.team6.repository.CustomerRepository;
import com.finki.ikt.team6.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(InvalidCustomerIdException::new);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = findById(id);
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public Customer createCustomer(User user, String name, String surname, String emaiil, String address, int grade) {
        Customer customer=new Customer(user, name, surname, emaiil, address, grade);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, User user, String name, String surname, String emaiil, String address, int grade) {
        Customer customer = findById(id);

        customer.setUser(user);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setEmaiil(emaiil);
        customer.setAddress(address);
        customer.setGrade(grade);

        return customerRepository.save(customer);
    }
}
