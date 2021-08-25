package com.citi.training.Portfolio.Manager.repo;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.entities.HistoricalAccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface HistoricalAccountDataRepository extends JpaRepository<HistoricalAccountData,Integer> {

    //public Iterable<HistoricalAccountData> findByAccount_id(int id);
    //public List<HistoricalAccountData> findAllByAccount_id(Integer id);
    List<HistoricalAccountData> findAllByAccountId(int id);
    List<HistoricalAccountData> findHistoricalAccountDataByDateAndAccountId(Date date, int id);
    HistoricalAccountData findFirstByAccountIdOrderByDateDesc(int id);
    List<HistoricalAccountData> findHistoricalAccountDataByDateBetweenAndAccountId(Date startDate, Date endDate, int id);
}
