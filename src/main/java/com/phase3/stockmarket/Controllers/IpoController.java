package com.phase3.stockmarket.Controllers;

import java.util.List;

import com.phase3.stockmarket.Entities.Ipo;
import com.phase3.stockmarket.Repositories.IpoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class IpoController {
    
    @Autowired
    IpoRepository ipoRepository;

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ipo", method = RequestMethod.POST)
    public String setIpo(@RequestBody Ipo ipo){
        Ipo e = this.ipoRepository.save(ipo);
        return e.toString();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ipo", method = RequestMethod.GET)
    public List<Ipo> getIpos(){
        return this.ipoRepository.findAll();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ipo/{id}", method = RequestMethod.GET)
    public Ipo getIpoById(@PathVariable long id){
        return this.ipoRepository.findIpoById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ipo/{id}", method = RequestMethod.DELETE)
    public String deleteIpo(@PathVariable long id){
        this.ipoRepository.deleteById(id);
        return "Ipo deleted";
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ipo/{id}", method = RequestMethod.PUT)
    public String updateIpo(@RequestBody Ipo ipo, @PathVariable("id") long id){
        ipo.setId(id);
        Ipo e = this.ipoRepository.save(ipo);
        return e.toString();
    }
}
