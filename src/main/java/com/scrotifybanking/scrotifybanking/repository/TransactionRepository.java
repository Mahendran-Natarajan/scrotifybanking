package com.scrotifybanking.scrotifybanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.scrotifybanking.scrotifybanking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}