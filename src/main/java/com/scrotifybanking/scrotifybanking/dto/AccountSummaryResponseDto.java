package com.scrotifybanking.scrotifybanking.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Account summary response dto.
 */
@NoArgsConstructor
@AllArgsConstructor
public class AccountSummaryResponseDto {

    private String statusMessage;
    private Integer statusCode;
    private Long accountNumber;
    private Double balance;
    private String name;
    private List<TransactionDto> transactions;

    /**
     * Gets status message.
     *
     * @return the status message
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets status message.
     *
     * @param statusMessage the status message
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets account number.
     *
     * @return the account number
     */
    public Long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets account number.
     *
     * @param accountNumber the account number
     */
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets transactions.
     *
     * @return the transactions
     */
    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    /**
     * Sets transactions.
     *
     * @param transactions the transactions
     */
    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
