package com.customer.CustomerManagement.service.impl;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Override
    public String saveCustomer(CustomerDTO customerDTO)
    {
        System.out.println("Customer Service "+customerDTO);
        return "saved";
    }

}
