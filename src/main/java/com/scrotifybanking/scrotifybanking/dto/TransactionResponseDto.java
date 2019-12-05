package com.scrotifybanking.scrotifybanking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Transaction response dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {

    private String statusMessage;
    private Integer statusCode;

}
