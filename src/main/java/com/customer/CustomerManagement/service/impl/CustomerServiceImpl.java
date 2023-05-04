package com.customer.CustomerManagement.service.impl;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.entity.Customer;
import com.customer.CustomerManagement.repo.CustomerRepo;
import com.customer.CustomerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO)
    {
        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActiveStatus()
        );
        System.out.println("Customer Service "+customerDTO);
        customerRepo.save(customer);
        return "saved";
    }

}
