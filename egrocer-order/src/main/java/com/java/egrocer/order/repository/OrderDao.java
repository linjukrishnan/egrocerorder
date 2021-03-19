package com.java.egrocer.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.egrocer.order.model.EgrocerOrderEntity;

@Repository
public interface OrderDao extends JpaRepository<EgrocerOrderEntity, Long> {

}