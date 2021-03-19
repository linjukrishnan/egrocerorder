package com.java.egrocer.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.egrocer.order.model.EgrocerOrder;
import com.java.egrocer.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value = "/orderProduct")
	public String orderProduct(@RequestBody Map<String,Object> request)
	{
		List<Integer> pIdList = (List<Integer>) request.get("productIds");
		List<Long> longPIdList = pIdList.stream()
		        .mapToLong(Integer::longValue)
		        .boxed().collect(Collectors.toList());
		Map<String,Object> orderDetails = (Map<String, Object>) request.get("orderDetails");
		List<EgrocerOrder> orderList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper(); 
		EgrocerOrder order = mapper.convertValue(orderDetails, EgrocerOrder.class);
		EgrocerOrder orderResponse = orderService.orderProduct(longPIdList,order);
		if(orderResponse.getOrderId() != 0) {
			return "Order placed successfully";
		}
		return "Order failed";
	}
}
