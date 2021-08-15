package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Transaction;
import com.citi.training.Portfolio.Manager.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction getTransactionById(int id){
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            return transaction.get();
        }else{
            return null;
        }

    }

    @Override
    public List<Transaction> getTransactionsByAccount_id(int account_id) {
        return transactionRepository.findTransactionsByAccountId(account_id);
        //return null;
    }

    @Override
    public Iterable<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByDate(String date) {
        return transactionRepository.findTransactionsByDate(date);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transaction.setId(0);
        transactionRepository.save(transaction);
    }

}
