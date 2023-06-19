package com.testTask.freedom.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurDate {
    private String date;
    private String timezoneType;
    private String timezone;
}
