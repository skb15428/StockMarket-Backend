package com.phase3.stockmarket.Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.phase3.stockmarket.Entities.StockPrice;
import com.phase3.stockmarket.Helper.ExcelHelper;
import com.phase3.stockmarket.Repositories.StockPriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StockPriceService {

    @Autowired
    StockPriceRepository stockPriceRepository;
    
    public void save(MultipartFile file){
        try {
            List<StockPrice> stockPrices = ExcelHelper.convertToStockPrice((InputStream) file.getInputStream());
            this.stockPriceRepository.saveAll(stockPrices);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<StockPrice> getAllStockPrice(){
        return this.stockPriceRepository.findAll();
    }
}
