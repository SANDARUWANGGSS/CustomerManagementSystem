package com.customer.CustomerManagement.dto.request;

import com.customer.CustomerManagement.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO
{
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private String balanceQty;
    private String supplierPrice;
    private String sellingPrice;
}
