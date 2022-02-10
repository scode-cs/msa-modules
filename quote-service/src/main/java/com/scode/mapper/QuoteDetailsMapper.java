package com.scode.mapper;

import com.scode.model.QuoteDetailsResponse;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;

import java.time.ZonedDateTime;

@Component
public class QuoteDetailsMapper {

    public QuoteDetailsResponse map(Stock stock) {
        return new QuoteDetailsResponse(stock.isValid(), stock.getName(), stock.getSymbol(),
                stock.getQuote().getPrice(), stock.getCurrency(),
                stock.getQuote().getTimeZone(), ZonedDateTime.now(),
                stock.getStockExchange(),
                new QuoteDetailsResponse.Details(
                        stock.getQuote().getOpen(), stock.getQuote().getDayLow(),
                        stock.getQuote().getDayHigh(), stock.getQuote().getPreviousClose(),
                        stock.getQuote().getVolume(), stock.getQuote().getAvgVolume(),
                        stock.getQuote().getChange(), stock.getQuote().getChangeInPercent()));
    }
}
