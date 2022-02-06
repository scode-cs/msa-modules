package com.scode.service;

import com.scode.constant.ExchangeEnum;
import com.scode.domain.FinanceService;
import com.scode.mapper.QuoteDetailsMapper;
import com.scode.model.QuoteDetailsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.time.ZonedDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final QuoteDetailsMapper quoteDetailsMapper;

    @Override
    public QuoteDetailsResponse fetchDetail(String symbol, ExchangeEnum exchange) {
        try {
            var exchangeSymbol = symbol.toUpperCase() + (ExchangeEnum.NSE.equals(exchange) ? ".NS" : "");
            Stock stock = YahooFinance.get(exchangeSymbol);
            log.info("Data fetched: {} - {}", stock.getName(), stock.getQuote().getPrice());

            return quoteDetailsMapper.map(stock);
        } catch (IOException e) {
            log.error("Quote Fetch Exception", e);
            return null;
        }
    }
}
