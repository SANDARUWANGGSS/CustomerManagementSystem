package com.customer.CustomerManagement.util.mappers;

import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import com.customer.CustomerManagement.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper
{
    List<ItemGetResponseDTO> entityListToDTOList(List<Item> items);
}
