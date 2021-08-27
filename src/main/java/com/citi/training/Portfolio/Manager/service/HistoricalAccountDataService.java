package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import com.sun.xml.bind.v2.model.core.ID;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface HistoricalAccountDataService {
    //Iterable<HistoricalAccountData> getHistory();
    List<HistoricalAccountData> getLastWeeksData(Date currentDate, int id);
    List<HistoricalAccountData> getLastMonthsData(Date currentDate, int id);
    List<HistoricalAccountData> getLastQuarterData(Date currentDate, int id);
    List<HistoricalAccountData> getPastMonthsData(Date currentDate, int id);
    List<HistoricalAccountData> getPastYearData(Date currentDate, int id);
    List<HistoricalAccountData> getLastYearData(Date currentDate, int id);
    List<HistoricalAccountData> getYearToDateData(Date currentDate, int id);
    List<HistoricalAccountData> getDataById(int id);
    List<HistoricalAccountData> getDataByDateAndId(Date date, int id);
    Iterable<HistoricalAccountData> getAllData();
    double updateCash(char action, int accountId, double amount);
    HistoricalAccountData getLatestAccountDataById(int id);
    void addHistoricalData(HistoricalAccountData historicalAccountData);
}
