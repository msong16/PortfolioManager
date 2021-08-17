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

import java.util.Collection;
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
    public List<HistoricalAccountData> getDataById(int id){
        //List<HistoricalAccountData> data =  historicalAccountDataRepository.findAll();
        //List<HistoricalAccountData> data =  historicalAccountDataRepository.findAllByAccount_id(id);
       return historicalAccountDataRepository.findAllByAccountId(id);
       //return null;
        //return data;
    }
}
