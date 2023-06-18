package com.testTask.freedom.client;

import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "exchangeRates", url = "https://halykbank.kz/api/exchangerates")
public interface FeignClient {

    @GetMapping("/{currency}/{period}")
    List<ExchangeRateResponseDto> getExchangeRate(@PathVariable(name = "currency") String currency,
                                                  @PathVariable(name = "period") String period);
}
