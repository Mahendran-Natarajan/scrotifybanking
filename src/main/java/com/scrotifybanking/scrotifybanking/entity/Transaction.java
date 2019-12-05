package com.scrotifybanking.scrotifybanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The type Transaction.
 */
@Entity
@Table(name = "transaction")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "payee_no")
    private Long payeeNo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountNo")
    private Account account;
    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    /*@Column(name = "from_account_no")
    private Integer fromAccountNo;*/
    @Column(name = "amount")
    private Double amount;
    @Column(name = "transaction_type")
    private String transactionType;

    /**
     * Gets payee no.
     *
     * @return the payee no
     */
    public Long getPayeeNo() {
        return payeeNo;
    }

    /**
     * Sets payee no.
     *
     * @param payeeNo the payee no
     */
    public void setPayeeNo(Long payeeNo) {
        this.payeeNo = payeeNo;
    }

    /**
     * Gets transaction type.
     *
     * @return the transaction type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets transaction type.
     *
     * @param transactionType the transaction type
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * Sets transaction id.
     *
     * @param transactionId the transaction id
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets transaction date.
     *
     * @return the transaction date
     */
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets transaction date.
     *
     * @param transactionDate the transaction date
     */
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}