package com.customer.CustomerManagement.service;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService
{
    public String saveCustomer(CustomerDTO customerDTO);


    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
