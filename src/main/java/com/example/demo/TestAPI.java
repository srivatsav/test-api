package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Stock;

@RestController("/stock")
public class TestAPI {
    static List<Stock> availableStocks;
    static {

        availableStocks = new ArrayList<>();

        Stock stock1 = new Stock();
        stock1.setStockId(1L);
        stock1.setStockName("stock1 Name");
        stock1.setStockPrice(10L);

        Stock stock2 = new Stock();
        stock2.setStockId(2L);
        stock2.setStockName("stock2 Name");
        stock2.setStockPrice(20L);

        availableStocks.add(stock1);
        availableStocks.add(stock2);

    }

    @RequestMapping(value = "/getAllStocks", method = RequestMethod.GET)
    public @ResponseBody List<Stock> getAllStocks() {
        return availableStocks;
    }

    @RequestMapping(value = "/getSingleStock", method = RequestMethod.GET)
    public Stock getSingleStock(@RequestParam String id) {
        Stock finalStock = null;
        for (Stock stock : availableStocks) {
            if (stock.getStockId() == Long.parseLong(id)) {
                finalStock = stock;
            }
        }
        return finalStock;
    }
    
    //TODO: (vishal) API for creating a new stock
    
    
    
    //TODO: (vishal) API for updating an existing stock's price.
    
    
    //TODO: (vishal) API for deleting an existing stock for a given Id.
}
