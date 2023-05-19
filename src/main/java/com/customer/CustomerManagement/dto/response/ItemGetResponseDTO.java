package com.customer.CustomerManagement.dto.response;

import com.customer.CustomerManagement.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponseDTO
{
    private int itemId;
    private String itemName;
    private String balanceQty;
    private String supplierPrice;
    private String sellingPrice;
    private boolean activeStatus;
}
