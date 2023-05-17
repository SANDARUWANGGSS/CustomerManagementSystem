package com.customer.CustomerManagement.service;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.CustomerUpdateDTO;

public interface CustomerService
{
    public String saveCustomer(CustomerDTO customerDTO);


    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    String deleteCustomer(int customerId);
}
