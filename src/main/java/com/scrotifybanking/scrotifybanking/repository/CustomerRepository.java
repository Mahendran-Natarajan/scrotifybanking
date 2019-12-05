package com.scrotifybanking.scrotifybanking.repository;

import com.scrotifybanking.scrotifybanking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}