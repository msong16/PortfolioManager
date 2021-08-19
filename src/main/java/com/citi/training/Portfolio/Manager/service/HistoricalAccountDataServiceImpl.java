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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<HistoricalAccountData> getDataByDateAndId(Date date, int id){
        return historicalAccountDataRepository.findHistoricalAccountDataByDateAndAccountId(date, id);
    }



}
