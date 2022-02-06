package com.scode.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDetailsResponse {
    private Boolean valid;
    private String name;
    private String symbol;
    private BigDecimal price;
    private String currency;
    private TimeZone timeZone;
    private ZonedDateTime fetchedAt;
    private String exchange;
    private Details details;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Details {
        private BigDecimal open;
        private BigDecimal dayLow;
        private BigDecimal dayHigh;
        private BigDecimal previousClose;
        private Long volume;
        private Long avgVolume;
        private BigDecimal change;
        private BigDecimal changePercent;
    }
}
