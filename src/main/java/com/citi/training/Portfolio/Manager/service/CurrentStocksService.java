package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.CurrentStocks;

import java.util.List;

public interface CurrentStocksService {
    Iterable<CurrentStocks> getAll();
    List<CurrentStocks> getCurrentStocksByAccountId(int accountId);
    CurrentStocks getCurrentStocksByAccountIdAndStockName(int accountId, String stockName);
    void addCurrentStocks(CurrentStocks currentStocks);
    void deleteCurrentStocksByAccountIdAndStockName(int accountId, String stockName);
    void updateSharesByAccountIdAndStockName(int accountId, String stockName, int shares);
}
