package com.phase3.stockmarket.Entities;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockPrice {
    
    @Id
    @GeneratedValue
    private long id;
    
    private long companyCode;
    
    private String exchange;
    private double price;
    private Date date;
    
    private Time time;
    
    public StockPrice() {
    }
    
    public StockPrice(long id, long companyCode, String exchange, double price, Date date, Time time) {
        this.id = id;
        this.companyCode = companyCode;
        this.exchange = exchange;
        this.price = price;
        this.date = date;
        this.time = time;
    }

    public long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(long companyCode) {
        this.companyCode = companyCode;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
