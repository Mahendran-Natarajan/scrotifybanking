package com.scrotifybanking.scrotifybanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The type Account.
 */
@Entity
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", initialValue = 100000)
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "account_no")
    private Long accountNo;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_status")
    private String accountStatus;

//  @Column(name = "customer_id")
//  private String customerId;

    @Column(name = "available_balance")
    private Double availableBalance;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transaction> transactionList;

    /**
     * Gets account no.
     *
     * @return the account no
     */
    public Long getAccountNo() {
        return accountNo;
    }

    /**
     * Sets account no.
     *
     * @param accountNo the account no
     */
    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * Gets account type.
     *
     * @return the account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets account type.
     *
     * @param accountType the account type
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Gets account status.
     *
     * @return the account status
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * Sets account status.
     *
     * @param accountStatus the account status
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * Gets available balance.
     *
     * @return the available balance
     */
    public Double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets available balance.
     *
     * @param availableBalance the available balance
     */
    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets transaction list.
     *
     * @return the transaction list
     */
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    /**
     * Sets transaction list.
     *
     * @param transactionList the transaction list
     */
    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }


}