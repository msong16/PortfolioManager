package com.citi.training.Portfolio.Manager.repo;

import com.citi.training.Portfolio.Manager.entities.CurrentStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentStocksRepository extends JpaRepository<CurrentStocks,Integer>{

    List<CurrentStocks> getCurrentStocksByAccountId(int accountsId);
    CurrentStocks getCurrentStocksByAccountIdAndStockName(int accountId, String stockName);
}
