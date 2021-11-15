package com.phase3.stockmarket.Repositories;

import com.phase3.stockmarket.Entities.StockExchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
    public StockExchange findStockExchangeById(long id);
    public StockExchange findStockExchangeByName(String name);
}
