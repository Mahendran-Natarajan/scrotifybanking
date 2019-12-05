package com.scrotifybanking.scrotifybanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Customer.
 */
@Table(name = "customer")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_password")
    private String customerPassword;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "customer_dob")
    private Date customerDob;

    @Column(name = "customer_mobileno")
    private Integer customerMobileno;

    @Column(name = "customer_city")
    private String customerCity;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accountList;

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets customer name.
     *
     * @param customerName the customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets customer email.
     *
     * @return the customer email
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets customer email.
     *
     * @param customerEmail the customer email
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Gets customer password.
     *
     * @return the customer password
     */
    public String getCustomerPassword() {
        return customerPassword;
    }

    /**
     * Sets customer password.
     *
     * @param customerPassword the customer password
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
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
     * Gets customer dob.
     *
     * @return the customer dob
     */
    public Date getCustomerDob() {
        return customerDob;
    }

    /**
     * Sets customer dob.
     *
     * @param customerDob the customer dob
     */
    public void setCustomerDob(Date customerDob) {
        this.customerDob = customerDob;
    }

    /**
     * Gets customer mobileno.
     *
     * @return the customer mobileno
     */
    public Integer getCustomerMobileno() {
        return customerMobileno;
    }

    /**
     * Sets customer mobileno.
     *
     * @param customerMobileno the customer mobileno
     */
    public void setCustomerMobileno(Integer customerMobileno) {
        this.customerMobileno = customerMobileno;
    }

    /**
     * Gets customer city.
     *
     * @return the customer city
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Sets customer city.
     *
     * @param customerCity the customer city
     */
    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    /**
     * Gets account list.
     *
     * @return the account list
     */
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Sets account list.
     *
     * @param accountList the account list
     */
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}