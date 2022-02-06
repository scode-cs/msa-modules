package com.scode.domain;

import com.scode.constant.ExchangeEnum;
import com.scode.model.StockDetailsResponse;

public interface StockService {
    StockDetailsResponse fetch(String symbol, ExchangeEnum exchange);
}
