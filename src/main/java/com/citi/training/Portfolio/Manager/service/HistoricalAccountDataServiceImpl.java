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
    public List<HistoricalAccountData> getDataById(int id){ //using account id
       return historicalAccountDataRepository.findAllByAccountId(id);
    }

    public List<HistoricalAccountData> getDataByDateAndId(Date date, int id){
        return historicalAccountDataRepository.findHistoricalAccountDataByDateAndAccountId(date, id);
    }

    public List<HistoricalAccountData> getLastWeeksData(Date currentDate, int id){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE,-7); //subtract 7 days from currentdate
        Date startDate = cal.getTime();
        return historicalAccountDataRepository.findHistoricalAccountDataByDateBetweenAndAccountId(startDate,currentDate,id);
    }
}
