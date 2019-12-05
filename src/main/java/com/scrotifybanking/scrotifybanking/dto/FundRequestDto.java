package com.scrotifybanking.scrotifybanking.dto;

import javax.validation.constraints.NotBlank;

/**
 * The type Fund request dto.
 */
public class FundRequestDto {

    @NotBlank(message = "Amount should not be blank")
    private double amount;

    /**
     * Instantiates a new Fund request dto.
     */
    public FundRequestDto() {
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
