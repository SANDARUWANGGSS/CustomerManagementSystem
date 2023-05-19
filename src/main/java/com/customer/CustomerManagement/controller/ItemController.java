package com.customer.CustomerManagement.controller;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import com.customer.CustomerManagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin("http://localhost:8081/")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
    {
        System.out.println("Item :"+itemSaveRequestDTO);
        itemService.saveItem(itemSaveRequestDTO);

        return "Saved";
    }

    @GetMapping(path = "/getItemByNameAndStatus", params="name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName)
    {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDTOS;
    }

}
