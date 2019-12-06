package com.scrotifybanking.scrotifybanking.service;

import com.scrotifybanking.scrotifybanking.dto.*;
import com.scrotifybanking.scrotifybanking.entity.Account;
import com.scrotifybanking.scrotifybanking.entity.Customer;
import com.scrotifybanking.scrotifybanking.entity.Transaction;
import com.scrotifybanking.scrotifybanking.repository.AccountRepository;
import com.scrotifybanking.scrotifybanking.repository.CustomerRepository;
import com.scrotifybanking.scrotifybanking.repository.TransactionRepository;
import com.scrotifybanking.scrotifybanking.util.ScrotifyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Customer service.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;

    /**
     * The Account repository.
     */
    @Autowired
    AccountRepository accountRepository;

    /**
     * The Transaction repository.
     */
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public CustomerResponseDto registerCustomer(CustomerRequestDto customerRequestDto) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        LocalDate birthDate = customerRequestDto.getDob();
        LocalDate currentDate = LocalDate.now();
        Integer calculateAge = Period.between(birthDate, currentDate).getYears();
        Optional<Customer> customers = customerRepository.findByCustomerMobileNo(customerRequestDto.getPhone());
        if (!customers.isPresent()) {
            if (customerRequestDto.getAccountType().equalsIgnoreCase(ScrotifyConstant.ACCOUNT_TYPE) && calculateAge >= ScrotifyConstant.AGE_LIMIT) {
                Customer customer = new Customer();
                customer.setAccountType(customerRequestDto.getAccountType());
                customer.setCustomerCity(customerRequestDto.getCity());
                customer.setCustomerDob(customerRequestDto.getDob());
                customer.setCustomerEmail(customerRequestDto.getEmailId());
                customer.setCustomerName(customerRequestDto.getName());
                customer.setCustomerPassword(customerRequestDto.getPassword());
                customer.setCustomerMobileNo(customerRequestDto.getPhone());
                customerRepository.save(customer);
                Account account = new Account();
                account.setAccountStatus(ScrotifyConstant.ACCOUNT_ACTIVE_STATUS);
                account.getAccountNo();
                account.setCustomer(customer);
                account.setAccountType(customer.getAccountType());
                account.setAvailableBalance(1000.00);
                accountRepository.save(account);
                customerResponseDto.setCustomerId(customer.getCustomerId());
                customerResponseDto.setMessage(ScrotifyConstant.SUCCESS_MESSAGE);
                customerResponseDto.setStatusCode(ScrotifyConstant.SUCCESS_CODE);
            }
        } else {
            customerResponseDto.setMessage(ScrotifyConstant.FAILURE_MESSAGE);
            customerResponseDto.setStatusCode(ScrotifyConstant.FAILURE_CODE);
        }
        return customerResponseDto;
    }

    @Override
    public LoginResponseDto loginCustomer(LoginDto loginDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        Long customerId = loginDto.getCustId();
        String password = loginDto.getPassword();
        Optional<Customer> customer = customerRepository.findByCustomerId(customerId);
        if (customer.isPresent()) {
            if (customer.get().getCustomerId().equals(customerId) && customer.get().getCustomerPassword().equals(password)) {
                loginResponseDto.setName(customer.get().getCustomerName());
                loginResponseDto.setStatusCode(ScrotifyConstant.SUCCESS_CODE);
                loginResponseDto.setStatusMessage(ScrotifyConstant.SUCCESS_MESSAGE);

            } else {
                loginResponseDto.setStatusCode(ScrotifyConstant.FAILURE_CODE);
                loginResponseDto.setStatusMessage(ScrotifyConstant.FAILURE_MESSAGE);
            }
        }
        return loginResponseDto;
    }

    @Override
    public AccountSummaryResponseDto accountSummary(Long customerId) {
        AccountSummaryResponseDto accountSummaryResponseDto = new AccountSummaryResponseDto();
        Optional<Customer> customer = customerRepository.findByCustomerId(customerId);
        Optional<Account> accountDetails = accountRepository.findByCustomer(customer);
        List<Transaction> transactions = transactionRepository
                .findTop5ByAccountNoOrderByTransactionIdDesc(accountDetails);
        List<TransactionDto> transactionsList = new ArrayList<TransactionDto>();
        if (accountDetails.isPresent() && customer.isPresent()) {
            accountSummaryResponseDto.setAccountNumber(accountDetails.get().getAccountNo());
            accountSummaryResponseDto.setBalance(accountDetails.get().getAvailableBalance());
            accountSummaryResponseDto
                    .setName(customer.get().getCustomerName());
            accountSummaryResponseDto.setStatusMessage(ScrotifyConstant.SUCCESS_MESSAGE);
            accountSummaryResponseDto.setStatusCode(ScrotifyConstant.SUCCESS_CODE);
            for (Transaction transaction : transactions) {
                TransactionDto transactionDto = new TransactionDto();
                transactionDto.setAmount(transaction.getAmount());
                transactionDto.setTransactionDate(transaction.getTransactionDate());
                transactionDto.setTransactionType(transaction.getTransactionType());
                transactionDto.setPayeeNo(transaction.getPayeeNo());
                transactionDto.setTransactionId(transaction.getTransactionId());
                transactionsList.add(transactionDto);
            }
            accountSummaryResponseDto.setTransactions(transactionsList);
        }
        return accountSummaryResponseDto;
    }
}
