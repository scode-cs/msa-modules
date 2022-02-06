package com.scode.communication;

import com.scode.communication.client.QuoteServiceClient;
import com.scode.constant.ExchangeEnum;
import com.scode.model.StockDetailsResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuoteServiceCommunication {

    private final QuoteServiceClient quoteServiceClient;

    public Optional<StockDetailsResponse> fetch(String symbol, ExchangeEnum exchangeEnum) {
        try {
            return Optional.ofNullable(quoteServiceClient.getQuote(symbol, exchangeEnum));
        } catch (FeignException.FeignClientException feignClientException) {
            log.error("Quote Service Communication Exception, Status: {}", feignClientException.status(), feignClientException);
            return Optional.empty();
        }
    }
}
