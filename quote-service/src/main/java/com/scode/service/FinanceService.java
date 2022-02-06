package com.scode.service;

import com.scode.model.QuoteDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Slf4j
@Service
public class FinanceService {

    public QuoteDetailsResponse fetchDetail(String symbol) {
        try {
            Stock s = YahooFinance.get(symbol); //AXISBANK.NS
            log.info(s.getName() + ": " + s.getQuote().getPrice());

            return QuoteDetailsResponse.builder().valid(s.isValid()).symbol(symbol).name(s.getName())
                    .currency(s.getCurrency()).price(s.getQuote().getPrice()).build();
        } catch (IOException e) {
            log.error("Quote Fetch Exception", e);
            return null;
        }
    }
}
