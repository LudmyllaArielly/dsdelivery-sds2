package com.ludmylla.dsdelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludmylla.dsdelivery.dto.ProductDTO;
import com.ludmylla.dsdelivery.entities.Product;
import com.ludmylla.dsdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = productRepository.findAllByOrderByNameAsc();
		return list.stream()
				.map(x -> new ProductDTO(x))
				.collect(Collectors.toList());
	}
}
