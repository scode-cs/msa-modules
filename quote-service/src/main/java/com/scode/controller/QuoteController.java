package com.scode.controller;

import com.scode.constant.ExchangeEnum;
import com.scode.domain.FinanceService;
import com.scode.model.QuoteDetailsResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
@Tag(name = "Quote-Details")
public class QuoteController {

    private final FinanceService financeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuoteDetailsResponse fetchDetail(@RequestParam("symbol") String symbol,
                                            @RequestParam("exchange") ExchangeEnum exchange) {
        return financeService.fetchDetail(symbol, exchange);
    }
}
