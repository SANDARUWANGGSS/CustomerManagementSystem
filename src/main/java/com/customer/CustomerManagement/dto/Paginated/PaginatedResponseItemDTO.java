package com.customer.CustomerManagement.dto.Paginated;

import com.customer.CustomerManagement.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO
{
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
