package com.phase3.stockmarket.Entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Ipo {
    
    @Id
    @GeneratedValue
    private long id;

    private long price;
    private long lotsize;
    private Date date;

    @OneToOne(cascade=CascadeType.ALL)
    @JsonManagedReference
    private Company company;

    public Ipo() {
    }

    public Ipo(long id, long price, long lotsize, Date date, Company company) {
        this.id = id;
        this.price = price;
        this.lotsize = lotsize;
        this.date = date;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getLotsize() {
        return lotsize;
    }

    public void setLotsize(long lotsize) {
        this.lotsize = lotsize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
}
