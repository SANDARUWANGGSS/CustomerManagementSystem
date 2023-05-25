package com.customer.CustomerManagement.controller;

import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import com.customer.CustomerManagement.dto.request.RequestOrderSaveDTO;
import com.customer.CustomerManagement.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin("http://localhost:8081/")
public class OrderController
{
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO)
    {
        System.out.println("Item :"+requestOrderSaveDTO);

        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",2), HttpStatus.CREATED
        );
        return responseEntity;
    }
}
