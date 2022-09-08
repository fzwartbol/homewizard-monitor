package com.frederik.homewizardenergyapiconsumer.controller;

import com.frederik.homewizardenergyapiconsumer.model.dto.MeasurementDTO;
import com.frederik.homewizardenergyapiconsumer.service.impl.IMeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class is a reactive controller for the Measurement entity
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/measurements")
public class MonitorReactiveController {

    private final IMeasurementService IMeasurementService;

    /**
     * This is the endpoint that the frontend will use to get de REST message
     * it returns a Flux (Reactive List) of Measurements, this is a stream JSON
     * @return
     */

    @GetMapping()
    public Flux<MeasurementDTO> getMeasurements() {
        return IMeasurementService.getMeasurements();
    }

    @GetMapping("/{id}")
    public Mono<MeasurementDTO> getMeasurementById(@PathVariable String id) {
        return IMeasurementService.getMeasurementById(id);
    }

    @GetMapping("/latest")
    public Mono<MeasurementDTO> getLatestMeasurement() {
        return IMeasurementService.getLatestMeasurement();
    }

}
