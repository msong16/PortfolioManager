package com.citi.training.Portfolio.Manager.rest;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.citi.training.Portfolio.Manager.service.AccountService;
import com.citi.training.Portfolio.Manager.service.HistoricalAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/historicalaccountdata")
public class HistoricalAccountDataController {

    @Autowired
    private HistoricalAccountDataService historicalAccountDataService;

//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public Iterable<HistoricalAccountData> getHistoricalAccountDataById(@PathVariable int id) {
//        return historicalAccountDataService.getDataById(id);
//    }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<HistoricalAccountData> getAllHistoricalData() {
        return historicalAccountDataService.getAllData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<HistoricalAccountData> getHistoricalAccountDataById(@PathVariable("id")  int id) {
        return historicalAccountDataService.getDataById(id);
    }
}
