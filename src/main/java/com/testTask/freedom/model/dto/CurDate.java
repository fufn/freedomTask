package com.testTask.freedom.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurDate {
    @Schema(description = "date of the currency rate")
    private String date;
    @Schema(description = "time zone type, etc. 6, 3")
    private String timezone_type;
    @Schema(description = "time zone name")
    private String timezone;
}
