package com.citi.training.Portfolio.Manager.repo;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Optional<Transaction> findById(int id);
    List<Transaction> findTransactionsByAccountId(int account_id);
    List<Transaction> findTransactionsByDate(String date);

    //List<Transaction> findTransactionsByStock_name(String stock);
    //public Iterable<Transaction> findTransactionsByDateAndAccount_id(Date date, int account_id);
}
