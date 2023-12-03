package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
