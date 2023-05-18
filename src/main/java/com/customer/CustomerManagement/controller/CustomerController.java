package com.customer.CustomerManagement.controller;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.CustomerUpdateDTO;
import com.customer.CustomerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers()
    {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(value="/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int CustomerId)
    {
        String deleted = customerService.deleteCustomer(CustomerId);
        return deleted;
    }

    @GetMapping("/getAllCustomersByActiveState/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState)
    {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}
