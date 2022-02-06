package com.scode.communication.client;

import com.scode.constant.ExchangeEnum;
import com.scode.model.StockDetailsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "quoteService", url = "${stock-config.api-communication.quote-service.host}")
public interface QuoteServiceClient {

    @GetMapping(value = "${stock-config.api-communication.quote-service.quote-detail-api}")
    StockDetailsResponse getQuote(@RequestParam("symbol") String symbol,
                                  @RequestParam("exchange") ExchangeEnum exchange);
}
