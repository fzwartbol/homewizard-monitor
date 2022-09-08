package com.frederik.homewizardenergyapiconsumer.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeasurementRequest {
    private LocalDateTime from;
    private LocalDateTime to;
}
