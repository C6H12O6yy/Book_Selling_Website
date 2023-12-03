package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.models.Orders;
import com.web.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	@Override
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}
	
	@Override
	public Orders findById(Integer id) {	
		Optional<Orders> result=ordersRepository.findById(id);
		Orders orders = null;
		if(result.isPresent()) {
			orders=result.get();
		}
		else {
			throw new RuntimeException("Không tìm thấy đơn");
		}
		return orders;
	}
	
	
	
}
