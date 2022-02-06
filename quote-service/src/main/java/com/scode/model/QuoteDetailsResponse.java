package com.scode.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDetailsResponse {
    private Boolean valid;
    private String name;
    private String symbol;
    private BigDecimal price;
    private String currency;
}
