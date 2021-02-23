package com.cognizant.Ribbonorderservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Ribbonorderservice.model.OrderHistory;

@Repository
public interface OrderDao  extends CrudRepository<OrderHistory, Integer>{

	//OrderHistory save(OrderHistory order);

}
