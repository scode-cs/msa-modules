package com.scode.controller;

import com.scode.constant.ExchangeEnum;
import com.scode.domain.StockService;
import com.scode.model.StockDetailsResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
@Tag(name = "Stock-Quote")
public class StockController {

    private final StockService quoteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/quote", produces = MediaType.APPLICATION_JSON_VALUE)
    public StockDetailsResponse fetchDetail(@RequestParam("symbol") String symbol,
                                            @RequestParam("exchange") ExchangeEnum exchange) {
        return quoteService.fetch(symbol, exchange);
    }
}
