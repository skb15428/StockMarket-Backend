package com.phase3.stockmarket.Entities;

// import java.util.HashSet;
// import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.ManyToMany;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StockExchange {
    
    @Id
    // @GeneratedValue
    private long id;
    private String name;

    // @JsonIgnore
    // @ManyToMany /*(mappedBy = "exchanges")*/
    // private Set<Company> companies=new HashSet<Company>();

    public StockExchange() {
    }
    public StockExchange(long id, String name) {
        this.id = id;
        this.name = name;
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
    @Override
    public String toString() {
        return "StockExchange [id=" + id + ", name=" + name + "]";
    }
    // public Set<Company> getCompanies() {
    //     return companies;
    // }
    // public void setCompanies(Set<Company> companies) {
    //     this.companies = companies;
    // }
    
    
}
