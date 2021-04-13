package com.example.shop.Repository;

import com.example.shop.Entity.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InOrderrRepo extends JpaRepository<Orderr,Integer> {
}
