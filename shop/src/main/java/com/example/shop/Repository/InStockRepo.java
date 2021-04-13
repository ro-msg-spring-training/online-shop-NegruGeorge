package com.example.shop.Repository;

import com.example.shop.Entity.Stock;
import com.example.shop.Entity.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InStockRepo  extends JpaRepository<Stock, StockId> {
}
