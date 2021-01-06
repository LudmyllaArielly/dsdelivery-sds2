package com.ludmylla.dsdelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludmylla.dsdelivery.dto.OrderDTO;
import com.ludmylla.dsdelivery.entities.Order;
import com.ludmylla.dsdelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = orderRepository.findOrderWithProducts();
		return list.stream()
				.map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}

}
