package com.cognizant.Ribbonorderservice.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Ribbonorderservice.configuration.OrderServiceProxy;
import com.cognizant.Ribbonorderservice.model.Cart;
import com.cognizant.Ribbonorderservice.model.OrderHistory;
import com.cognizant.Ribbonorderservice.service.IOrderService;


@RestController
@RequestMapping("api/order")

public class OrderController {
    @Autowired
    IOrderService orderService;
    @Value("${server.port}")
    private int serverPort;
    @Autowired
    OrderServiceProxy proxy;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String port() {
      String port= proxy.retrieveCart();
      return port;
       
    }
    
}
