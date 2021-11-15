package com.phase3.stockmarket.Controllers;

import java.util.List;

import com.phase3.stockmarket.Entities.StockExchange;
import com.phase3.stockmarket.Repositories.StockExchangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class StockExchangeController {
    
    @Autowired
    StockExchangeRepository stockExchangeRepository;

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange", method = RequestMethod.POST)
    public String setExchange(@RequestBody StockExchange exchange){
        StockExchange e = this.stockExchangeRepository.save(exchange);
        return e.toString();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange", method = RequestMethod.GET)
    public List<StockExchange> getExchanges(){
        return this.stockExchangeRepository.findAll();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange/{id}", method = RequestMethod.GET)
    public StockExchange getExchangeById(@PathVariable long id){
        return this.stockExchangeRepository.findStockExchangeById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange/name/{name}", method = RequestMethod.GET)
    public StockExchange getExchangeByName(@PathVariable String name){
        return this.stockExchangeRepository.findStockExchangeByName(name);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange/{id}", method = RequestMethod.DELETE)
    public String deleteExchange(@PathVariable long id){
        this.stockExchangeRepository.deleteById(id);
        return "Exchange deleted";
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/exchange/{id}", method = RequestMethod.PUT)
    public String updateExchange(@RequestBody StockExchange exchange, @PathVariable("id") long id){
        exchange.setId(id);
        StockExchange e = this.stockExchangeRepository.save(exchange);
        return e.toString();
    }
}
