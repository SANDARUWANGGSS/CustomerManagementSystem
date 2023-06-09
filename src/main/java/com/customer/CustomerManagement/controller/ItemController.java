package com.customer.CustomerManagement.controller;

import com.customer.CustomerManagement.dto.CustomerDTO;
import com.customer.CustomerManagement.dto.Paginated.PaginatedResponseItemDTO;
import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import com.customer.CustomerManagement.service.ItemService;
import com.customer.CustomerManagement.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin("http://localhost:8081/")
public class ItemController
{
    @Autowired
    private ItemService itemService;

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
//    {
//        System.out.println("Item :"+itemSaveRequestDTO);
//        itemService.saveItem(itemSaveRequestDTO);
//
//        return "Saved";
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
    {
        System.out.println("Item :"+itemSaveRequestDTO);
        String message = itemService.saveItem(itemSaveRequestDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
        return responseEntity;
    }

    @GetMapping(path = "/getItemByNameAndStatus", params="name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName)
    {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemGetResponseDTOS;
    }

    @GetMapping(path = "/getByNameWithMapStruct",params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(@RequestParam(value = "name") String itemName)
    {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusMapStruct(itemName);
        return itemDTOS;
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<StandardResponse> getAllItems()
    {
        List<ItemGetResponseDTO> allItems = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully get all items",allItems),HttpStatus.OK
        );
    }

    @GetMapping(path = "/getByNameWithPagination",params = {"activeStatus","page","size"})
    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    )
    {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully get all items",paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getAllItemsPagination",params = {"page","size"})
    public ResponseEntity<StandardResponse> getAllItems(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    )
    {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsPaginated(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully get all items",paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }
}
