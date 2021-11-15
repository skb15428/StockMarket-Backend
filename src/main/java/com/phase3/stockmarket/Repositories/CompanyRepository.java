package com.phase3.stockmarket.Repositories;

import com.phase3.stockmarket.Entities.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    public Company findCompanyById(long id);
    public Company findCompanyByName(String name);
}
