package com.frederik.homewizardenergyapiconsumer.consumer;

import com.frederik.homewizardenergyapiconsumer.model.dto.MeasurementDTO;
import com.frederik.homewizardenergyapiconsumer.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This class is responsible for consuming the HomeWizard Energy API.
 * Endpoints are set to default endpoint as described in the manual.
 * see https://homewizard-energy-api.readthedocs.io/endpoints.html
 * for changing default properties set corresponding field in application.yml
 *  @author Frederik Zwartbol
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class HomeWizardConsumer {
    @Value("${homewizard.ipaddress}")
    private String ipAddress;
    @Value("${homewizard.endpoint.basicinformation: /api}")
    private String API_ENDPOINT_BASIC_INFORMATION;
    @Value("${homewizard.endpoint.data: /api/v1/data}")
    private String API_ENDPOINT_DATA;

    private final MeasurementService measurementService;

    /**
     * Webclient is the non-blocking way of consuming the API (blocking would be RESTTemplate).
     */
    private final WebClient webClient = WebClient.create();

    /**
     * This method is scheduled to run every 5 minutes.
     * It consumes the HomeWizard Energy API and saves the measurements to the database.
     */

//    @Scheduled(fixedRate = 10000)
    public void consumeMeasurement() {
        log.info("Consuming measurements from HomeWizard Energy API");
        measurementService.saveMeasurement(
                    webClient.get()
                    .uri(buildEndpoint( ipAddress,API_ENDPOINT_DATA))
                    .retrieve()
                    .bodyToMono(MeasurementDTO.class))
                .subscribe();
    }

    public String buildEndpoint(String ipAddress, String endpoint) {
        return "http://" + ipAddress + endpoint;
    }

}
