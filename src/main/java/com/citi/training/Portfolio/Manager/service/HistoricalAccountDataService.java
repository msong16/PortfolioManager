package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.Collection;
import java.util.List;

public interface HistoricalAccountDataService {
    //Iterable<HistoricalAccountData> getHistory();

    List<HistoricalAccountData> getDataById(int id);
    Iterable<HistoricalAccountData> getAllData();
}
