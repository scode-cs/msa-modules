package com.scode.domain;

import com.scode.constant.ExchangeEnum;
import com.scode.model.QuoteDetailsResponse;

public interface FinanceService {

    QuoteDetailsResponse fetchDetail(String symbol, ExchangeEnum exchange);

}
