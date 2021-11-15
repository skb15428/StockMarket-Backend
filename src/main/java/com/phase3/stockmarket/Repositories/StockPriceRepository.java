package com.phase3.stockmarket.Repositories;

import com.phase3.stockmarket.Entities.StockPrice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
    
}
