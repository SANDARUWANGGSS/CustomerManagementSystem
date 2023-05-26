package com.customer.CustomerManagement.service.impl;

import com.customer.CustomerManagement.dto.request.RequestOrderSaveDTO;
import com.customer.CustomerManagement.entity.Order;
import com.customer.CustomerManagement.entity.OrderDetails;
import com.customer.CustomerManagement.repo.CustomerRepo;
import com.customer.CustomerManagement.repo.ItemRepo;
import com.customer.CustomerManagement.repo.OrderDetailsRepo;
import com.customer.CustomerManagement.repo.OrderRepo;
import com.customer.CustomerManagement.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService
{
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO)
    {
        Order order = new Order(
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal(),
                customerRepo.getById(requestOrderSaveDTO.getCustomer())
        );
        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId()))
        {
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}
                            .getType()
                    );
            for (int i = 0;i<orderDetails.size();i++)
            {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0)
            {
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }
}
