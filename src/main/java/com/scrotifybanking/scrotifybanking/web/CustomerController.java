package com.scrotifybanking.scrotifybanking.web;

import com.scrotifybanking.scrotifybanking.dto.FundRequestDto;
import com.scrotifybanking.scrotifybanking.dto.response.AccountNosDto;
import com.scrotifybanking.scrotifybanking.dto.response.ApiResponse;
import com.scrotifybanking.scrotifybanking.entity.Account;
import com.scrotifybanking.scrotifybanking.exception.CustomException;
import com.scrotifybanking.scrotifybanking.exception.MaintainBalanceException;
import com.scrotifybanking.scrotifybanking.exception.MinimumBalanceNotFoundException;
import com.scrotifybanking.scrotifybanking.repository.AccountRepository;
import com.scrotifybanking.scrotifybanking.service.TransactionService;
import com.scrotifybanking.scrotifybanking.util.ScrotifyConstant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Fund transfer response entity.
     *
     * @param custId         the cust id
     * @param toAccountNo    the to account no
     * @param fundRequestDto the fund request dto
     * @return the response entity
     * @throws MinimumBalanceNotFoundException the minimum balance not found exception
     * @throws MaintainBalanceException        the maintain balance exception
     */
    @PostMapping("/{custId}/accounts/{toAccountNo}")
    @CrossOrigin
    public ResponseEntity<ApiResponse> fundTransfer(@PathVariable String custId, @PathVariable String toAccountNo,
                                                    @RequestBody @Valid FundRequestDto fundRequestDto) throws MinimumBalanceNotFoundException, MaintainBalanceException {

        boolean checkMinimumBalance = transactionService.checkMinimumBalance(custId, ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, fundRequestDto.getAmount());
        ApiResponse response = new ApiResponse();
        response.setStatusCode(ScrotifyConstant.TRANSACTION_FAILED);
        response.setMessage(ScrotifyConstant.FUND_TRANSFER_FAILED);
        if (checkMinimumBalance) {
            if (transactionService.checkManintenanceBalance(custId, ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, fundRequestDto.getAmount(), ScrotifyConstant.MINIMUM_BALANCE_MAINTAIN)) {
                response = transactionService.transferFund(custId, toAccountNo, fundRequestDto.getAmount(), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE);
                response.setMessage(ScrotifyConstant.FUND_TRANSFER_SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new MinimumBalanceNotFoundException(ScrotifyConstant.MINIMUM_BALANCE_FAILED);
            }
        } else {
            throw new MaintainBalanceException(ScrotifyConstant.MAINTAIN_BALANCE_FAILED);
        }
    }

    /**
     * get list of accounts except current customer
     *
     * @param custId the cust id
     * @return all account nos
     */
    @GetMapping("/{custId}/accounts/")
    @CrossOrigin
    public ResponseEntity<AccountNosDto> getAllAccountNos(@PathVariable String custId) throws CustomException {

        AccountNosDto accountNosDtos = new AccountNosDto();
        List<Account> accounts = accountRepository.findAllByAccountNotCustomer(custId, ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE);
        if (accounts.size() > 0) {
            List<Long> accountNos = accounts.stream().map(Account::getAccountNo).collect(Collectors.toList());
            accountNosDtos.setAccountNos(accountNos);
        } else {
            throw new CustomException(ScrotifyConstant.CUSTOMER_ID_NOT_FOUND);
        }
        return new ResponseEntity<>(accountNosDtos, HttpStatus.OK);
    }


}