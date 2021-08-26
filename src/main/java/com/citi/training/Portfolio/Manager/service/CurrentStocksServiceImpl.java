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
    public CurrentStocks getCurrentStocksByAccountIdAndStockName(int accountId, String stockName) {
        return repo.getCurrentStocksByAccountIdAndStockName(accountId,stockName);
    }

    @Override
    public void addCurrentStocks(CurrentStocks currentStocks) {
        currentStocks.setId(0);
        repo.save(currentStocks);
    }

    @Override
    public void deleteCurrentStocksByAccountIdAndStockName(int accountId, String stockName) {
        CurrentStocks currentStocks = repo.getCurrentStocksByAccountIdAndStockName(accountId,stockName);
        if(currentStocks!=null){
            if(currentStocks.getShares()!=0) {
                repo.delete(currentStocks);
            }
        }

    }

    @Override
    public void updateSharesByAccountIdAndStockName(int accountId, String stockName, int shares) {
        CurrentStocks currentStocks = repo.getCurrentStocksByAccountIdAndStockName(accountId,stockName);
        currentStocks.setShares(shares);
        repo.save(currentStocks);
    }

    @Override
    public void deleteCurrentStocks(int id) {
        repo.deleteById(id);
    }
}
