package com.customer.CustomerManagement.controller;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.CustomerUpdateDTO;
import com.customer.CustomerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin("http://localhost:8081/")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        customerService.saveCustomer(customerDTO);
        System.out.println("Customer :"+customerDTO);
        return "Saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO)
    {
        String message = customerService.updateCustomer(customerUpdateDTO);
        System.out.println("Customer :"+customerUpdateDTO);
        return message;
    }

    @GetMapping(value = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int CustomerId)
    {
        CustomerDTO customerDTO=customerService.getCustomerById(CustomerId);

        return customerDTO;
    }

}
