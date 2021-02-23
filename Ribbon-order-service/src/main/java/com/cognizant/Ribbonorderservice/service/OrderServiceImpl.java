package com.cognizant.Ribbonorderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Ribbonorderservice.dao.OrderDao;
import com.cognizant.Ribbonorderservice.model.OrderHistory;
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	OrderDao orderDao;
	@Override
	public OrderHistory saveOrder(OrderHistory order) {
	return orderDao.save(order);
			
	}
	

}
