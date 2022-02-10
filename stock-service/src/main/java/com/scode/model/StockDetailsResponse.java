package com.scode.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.TimeZone;


public record StockDetailsResponse(
        Boolean valid, String name, String symbol, BigDecimal price, String currency,
        TimeZone timeZone, ZonedDateTime fetchedAt, String exchange,
        Details details) {

    public record Details(
            BigDecimal open, BigDecimal dayLow, BigDecimal dayHigh, BigDecimal previousClose,
            Long volume, Long avgVolume, BigDecimal change, BigDecimal changePercent
    ) {
    }
}
