package com.cognizant.OrderService.service;

import com.cognizant.OrderService.model.OrderHistory;

public interface IOrderService {

	OrderHistory saveOrder(OrderHistory order);

	
}
