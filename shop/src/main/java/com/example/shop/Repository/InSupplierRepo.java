package com.example.shop.Repository;

import com.example.shop.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InSupplierRepo extends JpaRepository<Supplier,Integer> {
}
