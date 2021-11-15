package com.phase3.stockmarket.Repositories;

import com.phase3.stockmarket.Entities.Ipo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoRepository extends JpaRepository<Ipo,Long> {

    Ipo findIpoById(long id);    
}
