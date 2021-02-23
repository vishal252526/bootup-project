package com.cognizant.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.OrderService.dao.OrderDao;
import com.cognizant.OrderService.model.OrderHistory;
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	OrderDao orderDao;
	@Override
	public OrderHistory saveOrder(OrderHistory order) {
	return orderDao.save(order);
			
	}
	

}
