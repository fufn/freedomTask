package com.testTask.freedom.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurDate {
    private String date;
    private String timezone_type;
    private String timezone;
}
