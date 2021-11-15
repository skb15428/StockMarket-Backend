package com.phase3.stockmarket.Controllers;

import java.util.List;

import com.phase3.stockmarket.Entities.Company;
import com.phase3.stockmarket.Repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CompanyController {
    
    @Autowired
    CompanyRepository companyRepository;

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company setCompany(@RequestBody Company company) {
        Company res = this.companyRepository.save(company);
        return res;
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable long id){
        return this.companyRepository.findCompanyById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company/name/{name}", method = RequestMethod.GET)
    public Company getCompanyByName(@PathVariable String name){
        return this.companyRepository.findCompanyByName(name);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public String deleteCompany(@PathVariable long id){
        this.companyRepository.deleteById(id);
        return "Company deleted";
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    public String updateCompany(@RequestBody Company company, @PathVariable("id") long id){
        company.setId(id);
        Company res = this.companyRepository.save(company);
        return res.toString();
    }
}
