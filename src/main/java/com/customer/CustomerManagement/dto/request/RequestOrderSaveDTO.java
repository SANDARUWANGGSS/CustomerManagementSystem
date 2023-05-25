package com.customer.CustomerManagement.dto.request;

import com.customer.CustomerManagement.entity.Customer;
import com.customer.CustomerManagement.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO
{
    private int customer;
    private Date date;
    private Double total;
    private Set<OrderDetails> orderDetails;
}
