package com.customer.CustomerManagement.repo;

import com.customer.CustomerManagement.entity.Item;
import com.customer.CustomerManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer>
{

}
