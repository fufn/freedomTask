package com.testTask.freedom.controller;

import com.testTask.freedom.model.dto.ExchangeRateResponseDto;
import com.testTask.freedom.model.enums.CurrencyCode;
import com.testTask.freedom.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/history")
    @Operation(summary = "get rates history for given currencies")
    @ApiResponse(responseCode = "200", description = "Found the rates history",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExchangeRateResponseDto.class)) })
    public List<ExchangeRateResponseDto> getExchangeRateHistory(@RequestParam List<CurrencyCode> currencyCodes) {
        return exchangeRateService.getExchangeRateHistory(currencyCodes);
    }
}
