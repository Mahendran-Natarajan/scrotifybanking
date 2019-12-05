package com.scrotifybanking.scrotifybanking.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The type Login response dto.
 */
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private String name;
    private String statusMessage;
    private Integer statusCode;

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
        return name;
    }

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
        this.name = name;
    }

	/**
	 * Gets status message.
	 *
	 * @return the status message
	 */
	public String getStatusMessage() {
        return statusMessage;
    }

	/**
	 * Sets status message.
	 *
	 * @param statusMessage the status message
	 */
	public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
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
