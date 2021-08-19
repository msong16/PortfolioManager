package com.citi.training.Portfolio.Manager.repo;

import com.citi.training.Portfolio.Manager.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findByName(String name);

}
