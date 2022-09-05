package com.frederik.homewizardenergyapiconsumer.service;

import com.frederik.homewizardenergyapiconsumer.model.BasicInformation;
import com.frederik.homewizardenergyapiconsumer.model.Measurement;
import com.frederik.homewizardenergyapiconsumer.repository.BasicInformationRepo;
import com.frederik.homewizardenergyapiconsumer.repository.MeasurementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepo measurementRepo;
    private final BasicInformationRepo basicInformationRepo;

    public Mono<Measurement> saveMeasurement(Measurement measurement) {
        return measurementRepo.save(measurement);
    }

    public Mono<BasicInformation> saveBasicInformation(BasicInformation basicInformation) {
        return basicInformationRepo.save(basicInformation);
    }

}
