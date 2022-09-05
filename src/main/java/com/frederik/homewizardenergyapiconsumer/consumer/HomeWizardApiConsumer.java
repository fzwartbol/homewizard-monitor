package com.frederik.homewizardenergyapiconsumer.consumer;

import com.frederik.homewizardenergyapiconsumer.model.BasicInformation;
import com.frederik.homewizardenergyapiconsumer.model.Measurement;
import com.frederik.homewizardenergyapiconsumer.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * This class is responsible for consuming the HomeWizard Energy API.
 * Endpoints are set to default endpoint as described in
 * see https://homewizard-energy-api.readthedocs.io/endpoints.html
 * for changing default properties set corresponding field in application.yml
 *  @author Frederik
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeWizardApiConsumer {
    @Value("${homewizard.ipaddress}")
    private String ipAddress;
    @Value("${homewizard.endpoint.basicinformation: /api}")
    private String API_ENDPOINT_BASIC_INFORMATION;
    @Value("${homewizard.endpoint.data: /api/v1/data}")
    private String API_ENDPOINT_DATA;

    private final MeasurementService measurementService;
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${homewizard.schedule.refresh.cron: 0 0/5 * * * ?}")
    public void consumeMeasurement() {
        try {
            measurementService.saveMeasurement(
                    restTemplate.getForObject(
                            buildEndpoint(ipAddress, API_ENDPOINT_DATA), Measurement.class));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @Scheduled(cron = "${homewizard.schedule.refresh.cron: 0 0/5 * * * ?}")
    public void consumeBasicInformation () {
        try {
            measurementService.saveBasicInformation(
                    restTemplate.getForObject(
                            buildEndpoint(ipAddress, API_ENDPOINT_BASIC_INFORMATION), BasicInformation.class));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public String buildEndpoint(String ipAddress, String endpoint) {
        return "http://" + ipAddress + endpoint;
    }

}
