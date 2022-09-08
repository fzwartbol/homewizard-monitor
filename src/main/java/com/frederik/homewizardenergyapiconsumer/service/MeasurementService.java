package com.frederik.homewizardenergyapiconsumer.service;

import com.frederik.homewizardenergyapiconsumer.model.dto.MeasurementDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MeasurementService {
    Flux<MeasurementDTO> getMeasurements();
    Mono<MeasurementDTO> getMeasurementById(String id);
    Mono<MeasurementDTO> saveMeasurement(Mono<MeasurementDTO> measurementDTO);
    Mono<MeasurementDTO> getLatestMeasurement();
}
