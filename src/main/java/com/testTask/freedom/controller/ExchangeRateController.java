package com.testTask.freedom.controller;

import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import com.testTask.freedom.model.enums.CurrencyCode;
import com.testTask.freedom.service.impl.ExchangeRateServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/exchange-rate")
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateController {
    private final ExchangeRateServiceImpl exchangeRateService;

    @GetMapping("/history")
    public List<ExchangeRateResponseDto> getExchangeRateHistory(@RequestParam List<CurrencyCode> currencyCodes){
        log.info("GET request to get exchange rate history with currency codes {}", currencyCodes);
        return exchangeRateService.getExchangeRateHistory(currencyCodes);
    }
}
