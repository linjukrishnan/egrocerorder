package com.java.egrocer.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.egrocer.order.model.EgrocerOrder;
import com.java.egrocer.order.model.EgrocerOrderEntity;
import com.java.egrocer.order.model.OrderMap;
import com.java.egrocer.order.model.OrderMapEntity;
import com.java.egrocer.order.repository.OrderDao;
import com.java.egrocer.order.repository.OrderMapDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDAO;
	
	@Autowired
	private OrderMapDao orderMapDao;

	@Override
	public EgrocerOrder orderProduct(List<Long> pIdList, EgrocerOrder order) {
		
		EgrocerOrderEntity orderEntity = new EgrocerOrderEntity();
		BeanUtils.copyProperties(order, orderEntity);
		EgrocerOrderEntity entity = orderDAO.save(orderEntity);
		
		pIdList.stream().forEach(id ->{
			OrderMap orderMap = new OrderMap();
			orderMap.setProductId(id);
			orderMap.setOrderId(entity.getOrderId());
			OrderMapEntity orderMapEntity = new OrderMapEntity();
			BeanUtils.copyProperties(orderMap, orderMapEntity);
			orderMapDao.save(orderMapEntity);
		});
		EgrocerOrder orderResponse = new EgrocerOrder();
		BeanUtils.copyProperties(entity, orderResponse);
		return orderResponse;
	}

}
