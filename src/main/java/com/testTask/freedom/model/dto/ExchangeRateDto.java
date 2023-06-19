package com.testTask.freedom.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testTask.freedom.model.enums.CurrencyCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExchangeRateDto {

    @JsonProperty(value = "date_at")
    private CurDate dateAt;
    private String value;
    private CurrencyCode currency;
}
