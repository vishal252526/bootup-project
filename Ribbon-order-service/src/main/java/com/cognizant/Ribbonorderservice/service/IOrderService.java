package com.cognizant.Ribbonorderservice.service;

import com.cognizant.Ribbonorderservice.model.OrderHistory;

public interface IOrderService {

	OrderHistory saveOrder(OrderHistory order);

	
}
