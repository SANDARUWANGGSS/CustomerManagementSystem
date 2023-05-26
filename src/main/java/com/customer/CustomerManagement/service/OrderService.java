package com.customer.CustomerManagement.service;

import com.customer.CustomerManagement.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
