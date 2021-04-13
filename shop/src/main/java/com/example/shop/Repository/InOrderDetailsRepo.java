package com.example.shop.Repository;

import com.example.shop.Entity.OrderDetail;
import com.example.shop.Entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InOrderDetailsRepo extends JpaRepository<OrderDetail, OrderDetailId> {
}
