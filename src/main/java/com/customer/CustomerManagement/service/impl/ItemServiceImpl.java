package com.customer.CustomerManagement.service.impl;

import com.customer.CustomerManagement.dto.request.ItemSaveRequestDTO;
import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import com.customer.CustomerManagement.entity.Item;
import com.customer.CustomerManagement.exception.NotFoundException;
import com.customer.CustomerManagement.repo.ItemRepo;
import com.customer.CustomerManagement.service.ItemService;
import com.customer.CustomerManagement.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO)
    {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return item.getItemName();
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId()))
        {
            itemRepo.save(item);
            return item.getItemId()+" Item Saved Successfully";
        }
        else
        {
            throw new DuplicateKeyException("Already Added Item");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName)
    {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStatusEquals(itemName,b);
        if (items.size()>0)
        {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}
                    .getType());
            return itemGetResponseDTOS;
        }
        else
        {
            throw new RuntimeException("Item is not active");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStatusEquals(itemName,b);
        if (items.size()>0)
        {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDTOList(items);
            return itemGetResponseDTOS;
        }
        else
        {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getAllItems()
    {
        List<Item> allItemsDB = itemRepo.findAll();
        if (allItemsDB.size()>0) {
            List<ItemGetResponseDTO> allItems = itemMapper.entityListToItemList(allItemsDB);
            return allItems;
        }
        else
        {
            throw new NotFoundException("No Items Found");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus) {
        List<Item> allItemsDB = itemRepo.findAllByActiveStatusEquals(activeStatus);
        if (allItemsDB.size()>0) {
            List<ItemGetResponseDTO> allItems = itemMapper.entityListToItemList(allItemsDB);
            return allItems;
        }
        else
        {
            throw new NotFoundException("No Items Found");
        }
    }
}
