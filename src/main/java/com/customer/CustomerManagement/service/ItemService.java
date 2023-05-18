package com.customer.CustomerManagement.service;

import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import org.springframework.stereotype.Service;

public interface ItemService
{

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
