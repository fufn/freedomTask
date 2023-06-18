package com.testTask.freedom.service;

import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import com.testTask.freedom.model.enums.CurrencyCode;

import java.util.List;

public interface ExchangeRateService {
    List<ExchangeRateResponseDto> getExchangeRateHistory(List<CurrencyCode> currencyCodes);
}
