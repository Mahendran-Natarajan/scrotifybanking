package com.scrotifybanking.scrotifybanking.service.impl;

import com.scrotifybanking.scrotifybanking.entity.Account;
import com.scrotifybanking.scrotifybanking.repository.AccountRepository;
import com.scrotifybanking.scrotifybanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The type Account service.
 */
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAllByAccountNotCustomer(String custId, String accountStatus, String accountType) {
        return accountRepository.findAllByAccountNotCustomer(custId, accountStatus, accountType);
    }
}
