package com.frederik.homewizardenergyapiconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableReactiveMongoRepositories
@EnableMongoAuditing
@SpringBootApplication
public class HomeWizardEnergyApiConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeWizardEnergyApiConsumerApplication.class, args);
    }

}
