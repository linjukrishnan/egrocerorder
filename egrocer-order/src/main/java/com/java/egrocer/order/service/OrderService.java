package com.java.egrocer.order.service;

import java.util.List;

import com.java.egrocer.order.model.EgrocerOrder;

public interface OrderService {

	public EgrocerOrder orderProduct(List<Long> pIdList, EgrocerOrder order);
}
