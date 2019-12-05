package com.scrotifybanking.scrotifybanking.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * The type Transaction statement dto.
 */
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStatementDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer customerId;
    private String month;

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
    public void setMonth(String month) {
        this.month = month;
    }
}
