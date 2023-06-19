package com.testTask.freedom.service.impl;

import com.testTask.freedom.client.FeignClient;
import com.testTask.freedom.model.dto.ExchangeRateDto;
import kz.namespace.my.rates.GetRatesResponse;
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
public class RatesServiceImpl {

    private final FeignClient feignClient;
    public GetRatesResponse getRatesResponse(List<String> currencyCodes){
        log.info("searching for rates in the past 10 days");
        GetRatesResponse response = new GetRatesResponse();
        LocalDate today = LocalDate.now();
        LocalDate pastDay = today.minusDays(10);
        // formatting the dates in order to match external api required params (for past 10 Days)
        String period = pastDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "-"
                + today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        List<ExchangeRateDto> exchangeRateDtos = new ArrayList<>();
        // adding rate information on every code element given in request
        for (String currencyCode : currencyCodes){
            exchangeRateDtos.addAll(feignClient.getExchangeRate(currencyCode.toLowerCase(), period));
        }
        mapToSoap(exchangeRateDtos, response);
        return response;
    }

    private void mapToSoap(List<ExchangeRateDto> exchangeRateDtos, GetRatesResponse getRatesResponses){
        log.info("Mapping dto to XML version");
        for (ExchangeRateDto exchangeRateDto: exchangeRateDtos){
            GetRatesResponse.ExchangeRateResponseDto exchangeRateResponseDto = new GetRatesResponse.ExchangeRateResponseDto();
            GetRatesResponse.ExchangeRateResponseDto.DateAt dateAt = new GetRatesResponse.ExchangeRateResponseDto.DateAt();
            dateAt.setDate(exchangeRateDto.getDateAt().getDate());
            dateAt.setTimezone(exchangeRateDto.getDateAt().getTimezone());
            dateAt.setTimezoneType(exchangeRateDto.getDateAt().getTimezoneType());
            exchangeRateResponseDto.setDateAt(dateAt);
            exchangeRateResponseDto.setValue(exchangeRateDto.getValue());
            exchangeRateResponseDto.setCurrency(exchangeRateDto.getCurrency().toString());
            getRatesResponses.getExchangeRateResponseDto().add(exchangeRateResponseDto);
        }
    }
}
