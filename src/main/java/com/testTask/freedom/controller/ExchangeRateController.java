package com.testTask.freedom.controller;

import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import com.testTask.freedom.model.enums.CurrencyCode;
import com.testTask.freedom.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/history")
    public List<ExchangeRateResponseDto> getExchangeRateHistory(@RequestParam List<CurrencyCode> currencyCodes) {
        return exchangeRateService.getExchangeRateHistory(currencyCodes);
    }
}
