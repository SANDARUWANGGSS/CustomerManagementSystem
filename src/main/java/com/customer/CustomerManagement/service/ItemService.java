package com.customer.CustomerManagement.service;

import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService
{

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(String itemName);

    List<ItemGetResponseDTO> getAllItems();
}
