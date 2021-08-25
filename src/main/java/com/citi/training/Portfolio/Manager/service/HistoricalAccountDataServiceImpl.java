package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.citi.training.Portfolio.Manager.repo.AccountRepository;
import com.citi.training.Portfolio.Manager.repo.HistoricalAccountDataRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class HistoricalAccountDataServiceImpl implements HistoricalAccountDataService {
    @Autowired
    private HistoricalAccountDataRepository historicalAccountDataRepository;

    //@Transactional(propagation = Propagation.REQUIRED)
    public Iterable<HistoricalAccountData> getAllData() {
        return historicalAccountDataRepository.findAll();

    }

    @Override
    public double updateCash(char action, int accountId, double amount) {
        HistoricalAccountData recentAccountData = historicalAccountDataRepository.findFirstByAccountIdOrderByDateDesc(accountId);
        double newCashAmount = recentAccountData.getCash();
        if(action == 'D') {
            newCashAmount += amount;
        } else if (action == 'W') {
            newCashAmount -= amount;
        }
        recentAccountData.setCash(newCashAmount);
        historicalAccountDataRepository.save(recentAccountData);
        return recentAccountData.getCash();
    }

    @Override
    public List<HistoricalAccountData> getDataById(int id){ //using account id
       return historicalAccountDataRepository.findAllByAccountId(id);
    }

    public List<HistoricalAccountData> getDataByDateAndId(Date date, int id) {
        return historicalAccountDataRepository.findHistoricalAccountDataByDateAndAccountId(date, id);
    }
    public List<HistoricalAccountData> getLastWeeksData(Date currentDate, int id){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE,-7); //subtract 7 days from currentdate
        Date startDate = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(startDate,currentDate,id);
    }

    public List<HistoricalAccountData> getLastMonthsData(Date currentDate, int id){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DATE,1);
        Date firstDay = cal.getTime();
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDay = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(firstDay,lastDay,id);
    }

    public List<HistoricalAccountData> getPastMonthsData(Date currentDate, int id){ //get past 31 days of data
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE,-31); //subtract 31 days from currentdate
        Date startDate = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(startDate,currentDate,id);
    }

    public List<HistoricalAccountData> getLastQuarterData(Date currentDate, int id){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH,-4);
        Date startDate = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(startDate,currentDate,id);
    }

    public List<HistoricalAccountData> getPastYearData(Date currentDate, int id){ //get past year (last 365 days) from current date
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.YEAR,-1);
        Date startDate = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(startDate,currentDate,id);
    }

    public List<HistoricalAccountData> getLastYearData(Date currentDate, int id){ //get last year data by calendar year
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.YEAR, -1);
        cal.set(Calendar.DAY_OF_YEAR,1);
        Date firstDay = cal.getTime();
        cal.set(Calendar.MONTH,11);
        cal.set(Calendar.DAY_OF_MONTH,31);
        Date lastDay = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(firstDay,lastDay,id);
    }

    public List<HistoricalAccountData> getYearToDateData(Date currentDate, int id){ //get data starting from jan 1 to the current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.DAY_OF_YEAR,1);
        Date firstDay = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(firstDay,currentDate,id);
    }
}
