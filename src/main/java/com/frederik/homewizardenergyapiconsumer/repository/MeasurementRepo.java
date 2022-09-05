package com.frederik.homewizardenergyapiconsumer.repository;

import com.frederik.homewizardenergyapiconsumer.model.Measurement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends ReactiveMongoRepository<Measurement, Long> {
}
