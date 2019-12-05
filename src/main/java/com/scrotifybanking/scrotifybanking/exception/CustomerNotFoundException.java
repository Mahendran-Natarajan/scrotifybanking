package com.scrotifybanking.scrotifybanking.exception;

/**
 * The type Customer not found exception.
 */
public class CustomerNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Customer not found exception.
     *
     * @param message the message
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }

}
