package com.customer.CustomerManagement.dto.request;

import com.customer.CustomerManagement.entity.Item;
import com.customer.CustomerManagement.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsDTO
{
    private String itemName;
    private double qty;
    private double amount;
    private int orders;
    private int items;
}
