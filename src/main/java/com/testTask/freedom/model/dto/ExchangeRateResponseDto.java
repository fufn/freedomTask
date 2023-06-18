package com.testTask.freedom.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExchangeRateResponseDto {

    @JsonProperty(value = "date_at")
    private CurDate dateAt;
    private String value;
    private String currency;
}
