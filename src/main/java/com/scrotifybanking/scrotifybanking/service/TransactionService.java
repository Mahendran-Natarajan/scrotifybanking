package com.scrotifybanking.scrotifybanking.service;

import com.scrotifybanking.scrotifybanking.dto.response.ApiResponse;

/**
 * The interface Transaction service.
 */
public interface TransactionService {

    /**
     * Check maintenance balance before withdraw
     *
     * @param custId        the cust id
     * @param accountStatus the account status
     * @param accountType   the account type
     * @param amount        the amount
     * @return boolean
     */
    public boolean checkMinimumBalance(String custId, String accountStatus, String accountType, double amount);

    /**
     * Check maintenance balance after withdraw
     *
     * @param custId          the cust id
     * @param accountStatus   the account status
     * @param accountType     the account type
     * @param amount          the amount
     * @param maintainBalance the maintain balance
     * @return boolean
     */
    public boolean checkManintenanceBalance(String custId, String accountStatus, String accountType, double amount, double maintainBalance);

    /**
     * Transfer fund api response.
     *
     * @param custId        the cust id
     * @param toAccountNo   the to account no
     * @param amount        the amount
     * @param accountStatus the account status
     * @param accountType   the account type
     * @return the api response
     */
    public ApiResponse transferFund(String custId, String toAccountNo, double amount, String accountStatus, String accountType);

}
