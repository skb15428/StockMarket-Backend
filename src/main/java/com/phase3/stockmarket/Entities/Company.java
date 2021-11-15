package com.phase3.stockmarket.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Company {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    private String description;
    private long valuation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "company_exchanges",
        joinColumns = @JoinColumn(name = "company_id"),
        inverseJoinColumns = @JoinColumn(name = "exchanges_id")
    )
    private Set<StockExchange> exchanges= new HashSet<>();

    @OneToOne(mappedBy = "company")
    @JsonBackReference
    private Ipo ipo;

    public Company() {
    }

    public Company(long id, String name, String description, long valuation, Set<StockExchange> exchanges) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.valuation = valuation;
        this.exchanges = exchanges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getValuation() {
        return valuation;
    }

    public void setValuation(long valuation) {
        this.valuation = valuation;
    }

    // public List<StockExchange> getExchanges() {
    //     return exchanges;
    // }

    // public void setExchanges(List<StockExchange> exchanges) {
    //     this.exchanges = exchanges;
    // }

    @Override
    public String toString() {
        return "Company [description=" + description + ", exchanges=" + exchanges + ", id=" + id + ", name=" + name
                + ", valuation=" + valuation + "]";
    }

    public Set<StockExchange> getExchanges() {
        return exchanges;
    }

    public void setExchanges(Set<StockExchange> exchanges) {
        this.exchanges = exchanges;
    } 

    
}
