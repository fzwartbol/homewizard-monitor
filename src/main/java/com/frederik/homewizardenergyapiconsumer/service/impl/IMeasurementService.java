package com.frederik.homewizardenergyapiconsumer.service.impl;

import com.frederik.homewizardenergyapiconsumer.model.dto.MeasurementDTO;
import com.frederik.homewizardenergyapiconsumer.repository.MeasurementRepo;
import com.frederik.homewizardenergyapiconsumer.service.MeasurementService;
import com.frederik.homewizardenergyapiconsumer.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class IMeasurementService implements MeasurementService {

    private final MeasurementRepo measurementRepo;

    /**
     * This method returns a Flux of MeasurementDTOs
     * @return
     */
    public Flux<MeasurementDTO> getMeasurements() {
        return measurementRepo.findAll().map(ModelMapper::entityToDto);
    }

    public Mono<MeasurementDTO> getMeasurementById(String id) {
        return measurementRepo.findById(id).map(ModelMapper::entityToDto);
    }

    /**
     * This method returns a Mono of MeasurementDTO
     * @return
     */
    public Mono<MeasurementDTO> saveMeasurement(Mono<MeasurementDTO> measurementDTO) {
        return measurementDTO.map(ModelMapper::dtoToEntity)
                .map(measurement -> {
                    measurement.setId(UUID.randomUUID().toString());
                    measurement.setMeasuredTime(System.currentTimeMillis());
                    return measurement;
                })
                .flatMap(measurementRepo::save)
                .map(ModelMapper::entityToDto);
    }

    public Mono<MeasurementDTO> getLatestMeasurement() {
        return measurementRepo.findFirstByOrderByMeasuredTimeDesc().map(ModelMapper::entityToDto);
    }
}
