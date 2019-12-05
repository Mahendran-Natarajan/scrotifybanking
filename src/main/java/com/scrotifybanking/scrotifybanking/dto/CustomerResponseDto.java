package com.scrotifybanking.scrotifybanking.dto;


/**
 * The type Customer response dto.
 */
public class CustomerResponseDto {

    private String customerId;
    private String message;
    private Integer statusCode;

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
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
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
}
