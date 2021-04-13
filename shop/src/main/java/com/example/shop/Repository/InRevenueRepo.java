package com.example.shop.Repository;

import com.example.shop.Entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InRevenueRepo extends JpaRepository<Revenue,Integer> {
}
