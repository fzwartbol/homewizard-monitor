package com.frederik.homewizardenergyapiconsumer.repository;

import com.frederik.homewizardenergyapiconsumer.model.entity.Measurement;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MeasurementRepo extends ReactiveCrudRepository<Measurement, String> {
    Mono<Measurement> findFirstByOrderByMeasuredTimeDesc();
}
