package com.scode.service;

import com.scode.communication.QuoteServiceCommunication;
import com.scode.constant.ExchangeEnum;
import com.scode.domain.StockService;
import com.scode.model.StockDetailsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final QuoteServiceCommunication quoteServiceCommunication;

    @Override
    public StockDetailsResponse fetch(String symbol, ExchangeEnum exchange) {
        return quoteServiceCommunication.fetch(symbol, exchange)
                .orElseThrow(RuntimeException::new);
    }
}
