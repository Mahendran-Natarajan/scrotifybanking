package com.scrotifybanking.scrotifybanking.repository;

import com.scrotifybanking.scrotifybanking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Transaction repository.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}