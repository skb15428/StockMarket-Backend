package com.phase3.stockmarket.Controllers;

import java.util.List;
import java.util.Map;

import com.phase3.stockmarket.Entities.StockPrice;
import com.phase3.stockmarket.Helper.ExcelHelper;
import com.phase3.stockmarket.Services.StockPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class StockPriceController {
    
    @Autowired
    private StockPriceService service;

    @PostMapping("/price")
    public ResponseEntity<?> uploadStockPrice(@RequestParam("file") MultipartFile file) {
        if(ExcelHelper.checkExcelFormat(file)){
            this.service.save(file);
            return ResponseEntity.ok(Map.of("message","File is successfully uploaded"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
        }
    }

    @GetMapping("/price")
    public List<StockPrice> getAllPrice(){
        return this.service.getAllStockPrice();
    }

}
