package com.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.models.Orders;

@Service
public interface OrdersService {

	Orders save(Orders orders);

	List<Orders> findAll();

	Orders findById(Integer id);

}
