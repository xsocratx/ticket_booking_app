package com.example.ticketapp.services.impl;

import com.example.ticketapp.model.Customer;
import com.example.ticketapp.repositories.CustomerRepository;
import com.example.ticketapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
