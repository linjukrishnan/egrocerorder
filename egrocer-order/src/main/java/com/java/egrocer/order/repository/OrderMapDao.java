package com.java.egrocer.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.egrocer.order.model.OrderMapEntity;

@Repository
public interface OrderMapDao extends JpaRepository<OrderMapEntity, Long> {

}