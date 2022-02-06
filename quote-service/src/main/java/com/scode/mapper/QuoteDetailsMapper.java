package com.scode.mapper;

import com.scode.model.QuoteDetailsResponse;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;

import java.time.ZonedDateTime;

@Component
public class QuoteDetailsMapper {

    public QuoteDetailsResponse map(Stock stock) {
        return QuoteDetailsResponse.builder().valid(stock.isValid()).symbol(stock.getSymbol()).name(stock.getName())
                .currency(stock.getCurrency()).price(stock.getQuote().getPrice())
                .timeZone(stock.getQuote().getTimeZone()).fetchedAt(ZonedDateTime.now())
                .exchange(stock.getStockExchange())
                .details(QuoteDetailsResponse.Details.builder()
                        .open(stock.getQuote().getOpen()).dayLow(stock.getQuote().getYearLow())
                        .dayHigh(stock.getQuote().getDayHigh()).previousClose(stock.getQuote().getPreviousClose())
                        .volume(stock.getQuote().getVolume()).avgVolume(stock.getQuote().getAvgVolume())
                        .change(stock.getQuote().getChange()).changePercent(stock.getQuote().getChangeInPercent()).build())
                .build();
    }
}
