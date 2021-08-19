package com.citi.training.Portfolio.Manager.rest;

import com.citi.training.Portfolio.Manager.entities.CurrentStocks;
import com.citi.training.Portfolio.Manager.entities.Transaction;
import com.citi.training.Portfolio.Manager.service.CurrentStocksService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currentstocks")
@CrossOrigin
public class CurrentStocksController {

    @Autowired
    private CurrentStocksService currentStocksService;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CurrentStocks> findAll(){
        return currentStocksService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/accountid/{accountId}")
    public List<CurrentStocks> findCurrentStocksByAccountId(@PathVariable("accountId")int accountID){
        return currentStocksService.getCurrentStocksByAccountId(accountID);
    }

    @RequestMapping(method = RequestMethod.GET, value="/accountIdAndStockName/{accountId}{stockName}")
    public CurrentStocks findCurrentStocksByAccountIdAndStockName(@PathVariable("accountId")int accountID, @PathVariable("stockName")String stockName){
        return currentStocksService.getCurrentStocksByAccountIdAndStockName(accountID,stockName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCurrentStocks(CurrentStocks currentStocks){
        currentStocksService.addCurrentStocks(currentStocks);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCurrentStocksByAccountIdAndStockName(int accountId, String stockName){
        currentStocksService.deleteCurrentStocksByAccountIdAndStockName(accountId,stockName);
    }


}
