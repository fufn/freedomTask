package com.testTask.freedom.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(type = "string", allowableValues = {"USD, EUR, RUB"})
public enum CurrencyCode {
    USD,
    EUR,
    RUB,
}
