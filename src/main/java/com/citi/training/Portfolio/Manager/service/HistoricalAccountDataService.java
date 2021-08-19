package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.sun.xml.bind.v2.model.core.ID;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface HistoricalAccountDataService {
    //Iterable<HistoricalAccountData> getHistory();

    List<HistoricalAccountData> getDataById(int id);
    List<HistoricalAccountData> getDataByDateAndId(Date date, int id);
    Iterable<HistoricalAccountData> getAllData();
}
