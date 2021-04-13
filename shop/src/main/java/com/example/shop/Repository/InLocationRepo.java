package com.example.shop.Repository;

import com.example.shop.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InLocationRepo  extends JpaRepository<Location,Integer> {
}
