package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.CurrentStocks;
import com.citi.training.Portfolio.Manager.repo.CurrentStocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentStocksServiceImpl implements CurrentStocksService {

    @Autowired
    private CurrentStocksRepository repo;

    @Override
    public Iterable<CurrentStocks> getAll() {
        return repo.findAll();
    }

    @Override
    public List<CurrentStocks> getCurrentStocksByAccountId(int accountId){
        return repo.getCurrentStocksByAccountId(accountId);
    }

    @Override
    public List<CurrentStocks> getCurrentStocksByAccountIdAndStockName(int accountId, String stockName) {
        return repo.getCurrentStocksByAccountIdAndStockName(accountId,stockName);
    }

    @Override
    public void addCurrentStocks(CurrentStocks currentStocks) {
        currentStocks.setId(0);
        repo.save(currentStocks);
    }
}
