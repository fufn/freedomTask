package com.testTask.freedom.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testTask.freedom.model.enums.CurrencyCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExchangeRateResponseDto {

    @JsonProperty(value = "date_at")
    @Schema(description = "object containing date properties")
    private CurDate dateAt;
    @Schema(description = "value of certain rate")
    private String value;
    @Schema(description = "currency code")
    private CurrencyCode currency;
}
