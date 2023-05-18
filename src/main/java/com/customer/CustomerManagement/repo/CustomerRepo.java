package com.customer.CustomerManagement.repo;

import com.customer.CustomerManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer>
{

    List<Customer> findAllByActiveStatusEquals(boolean activeState);
}
