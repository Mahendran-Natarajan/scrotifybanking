package com.scrotifybanking.scrotifybanking.web;

import com.scrotifybanking.scrotifybanking.dto.FundRequestDto;
import com.scrotifybanking.scrotifybanking.dto.response.AccountNosDto;
import com.scrotifybanking.scrotifybanking.dto.response.ApiResponse;
import com.scrotifybanking.scrotifybanking.entity.Account;
import com.scrotifybanking.scrotifybanking.exception.CustomException;
import com.scrotifybanking.scrotifybanking.repository.AccountRepository;
import com.scrotifybanking.scrotifybanking.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

/**
 * The type Customer controller test.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionService transactionService;

    @Mock
    private ModelMapper modelMapper;


    /**
     * Test get all accounts.
     *
     * @throws CustomException the custom exception
     */
    @Test
    public void testGetAllAccounts() throws CustomException {
        String custId = "123456";
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAccountNo(10L);
        accounts.add(account);

        Account account2 = new Account();
        account2.setAccountNo(20L);
        accounts.add(account2);

        Mockito.when(accountRepository.findAllByAccountNotCustomer(any(), any(), any())).thenReturn(accounts);

        ResponseEntity<AccountNosDto> accountNosDtos = customerController.getAllAccountNos(custId);
        Assert.assertNotNull(accountNosDtos);
        Assert.assertEquals(accountNosDtos.getStatusCode().value(), 200);
        Assert.assertEquals(accountNosDtos.getBody().getAccountNos().get(0).longValue(), 10L);
    }

    /**
     * Test get in valid cust.
     *
     * @throws CustomException the custom exception
     */
    @Test(expected = CustomException.class)
    public void testGetInValidCust() throws CustomException {
        String custId = "12345689";
        List<Account> accounts = new ArrayList<>();
        Mockito.when(accountRepository.findAllByAccountNotCustomer(any(), any(), any())).thenThrow(CustomException.class);
        customerController.getAllAccountNos(custId);
    }


    /**
     * Test fund transfer.
     *
     * @throws CustomException the custom exception
     */
    @Test
    public void testFundTransfer() throws CustomException {
        String custId = "123456";
        String toAccountNo = "2";
        FundRequestDto fundRequestDto = new FundRequestDto();
        fundRequestDto.setAmount(100);
        Mockito.when(transactionService.checkMinimumBalance(any(), any(), any(), any())).thenReturn(true);
        Mockito.when(transactionService.checkManintenanceBalance(any(), any(), any(), any(), any())).thenReturn(true);
        ResponseEntity<ApiResponse> response = customerController.fundTransfer(custId, toAccountNo, fundRequestDto);
        Assert.assertNotNull(response);
    }

}
