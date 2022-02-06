package com.scode.service;

import com.scode.model.QuoteDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.time.ZonedDateTime;

@Slf4j
@Service
public class FinanceService {

    public QuoteDetailsResponse fetchDetail(String symbol) {
        try {
            Stock s = YahooFinance.get(symbol); //AXISBANK.NS
            log.info("Data fetched: {} - {}", s.getName(), s.getQuote().getPrice());

            return QuoteDetailsResponse.builder().valid(s.isValid()).symbol(s.getSymbol()).name(s.getName())
                    .currency(s.getCurrency()).price(s.getQuote().getPrice())
                    .timeZone(s.getQuote().getTimeZone()).fetchedAt(ZonedDateTime.now())
                    .exchange(s.getStockExchange())
                    .details(QuoteDetailsResponse.Details.builder()
                            .open(s.getQuote().getOpen()).dayLow(s.getQuote().getYearLow())
                            .dayHigh(s.getQuote().getDayHigh()).previousClose(s.getQuote().getPreviousClose())
                            .volume(s.getQuote().getVolume()).avgVolume(s.getQuote().getAvgVolume())
                            .change(s.getQuote().getChange()).changePercent(s.getQuote().getChangeInPercent()).build())
                    .build();
        } catch (IOException e) {
            log.error("Quote Fetch Exception", e);
            return null;
        }
    }
}
