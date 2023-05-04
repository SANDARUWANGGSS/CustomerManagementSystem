package com.customer.CustomerManagement.service.impl;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.CustomerUpdateDTO;
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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO)
    {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId()))
        {
            Customer customer= customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);

            return "Updated customer";
        }
        else
        {
            throw new RuntimeException("No data found for that id");
        }

    }


}
