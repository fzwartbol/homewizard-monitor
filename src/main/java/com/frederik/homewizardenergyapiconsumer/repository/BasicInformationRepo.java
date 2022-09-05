package com.frederik.homewizardenergyapiconsumer.repository;

import com.frederik.homewizardenergyapiconsumer.model.BasicInformation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInformationRepo extends ReactiveMongoRepository<BasicInformation, Long> {
}
