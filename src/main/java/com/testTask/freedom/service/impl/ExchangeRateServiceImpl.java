package com.testTask.freedom.service.impl;

import com.testTask.freedom.controller.FeignClient;
import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import com.testTask.freedom.model.enums.CurrencyCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateServiceImpl {

    private final FeignClient feignClient;
    public List<ExchangeRateResponseDto> getExchangeRateHistory(List<CurrencyCode> currencyCodes) {
        log.debug("getting exchange rate history from external api");
        List<ExchangeRateResponseDto> responseDto = new ArrayList<>();
        LocalDate presentDate = LocalDate.now();
        LocalDate pastDate = presentDate.minusDays(10);
        String period = pastDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "-" + presentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        for (CurrencyCode currencyCode : currencyCodes){
            responseDto.addAll(feignClient.getExchangeRate(currencyCode, period));
        }

        return responseDto;
    }
}
