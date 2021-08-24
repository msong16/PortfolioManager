package com.citi.training.Portfolio.Manager.rest;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.citi.training.Portfolio.Manager.service.AccountService;
import com.citi.training.Portfolio.Manager.service.HistoricalAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/historicalaccountdata")
@CrossOrigin
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

    @RequestMapping(method = RequestMethod.GET, value = "/date/{id}/{date}")
    public List<HistoricalAccountData> getHistoricalAccountDataByDateAndId(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        //Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        //return historicalAccountDataService.getDataByDateAndId(formatter.format(date), id);
        return historicalAccountDataService.getDataByDateAndId(date, id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lastweek/{id}/{date}")
    public List<HistoricalAccountData> getLastWeekHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getLastWeeksData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lastmonth/{id}/{date}")
    public List<HistoricalAccountData> getLastMonthHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getLastMonthsData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pastmonth/{id}/{date}")
    public List<HistoricalAccountData> getPastMonthHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getPastMonthsData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lastquarter/{id}/{date}")
    public List<HistoricalAccountData> getLastQuarterHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getLastQuarterData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pastyear/{id}/{date}")
    public List<HistoricalAccountData> getPastYearHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getPastYearData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lastyear/{id}/{date}")
    public List<HistoricalAccountData> getLastYearHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getLastYearData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/yeartodate/{id}/{date}")
    public List<HistoricalAccountData> getYearToDateHistoricalAccountDataById(@PathVariable("id")  int id,@PathVariable("date")@DateTimeFormat(pattern="yyy-MM-dd") Date date) {
        return historicalAccountDataService.getYearToDateData(date,id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/current")
    public HistoricalAccountData getCurrentAccountDataById(@PathVariable("id")  int id) {
        return historicalAccountDataService.getDataById(id).get(historicalAccountDataService.getDataById(id).size() -1);
    }
}
