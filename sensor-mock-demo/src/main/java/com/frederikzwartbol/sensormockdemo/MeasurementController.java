package com.frederikzwartbol.sensormockdemo;

import com.frederikzwartbol.sensormockdemo.model.Measurement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;
import java.time.Duration;


@RestController
@RequestMapping("/api")
public class MeasurementController {

    @GetMapping(value = "/v1/data", produces = "application/stream+json")
    public Flux<Measurement> getMeasurement() {
        Flux<Measurement> eventFlux = Flux.generate(sink -> {
            sink.next(Measurement.builder()
                    .smr_version(50)
                    .meter_model("Sagemcom T210-D ESMR5.0")
                    .wifi_ssid("KPN6D41C6")
                    .wifi_strength(100)
                    .total_power_import_t1_kwh(4352.296)
                    .total_power_import_t2_kwh(4898.011)
                    .total_power_export_t1_kwh(3813.193)
                    .total_power_export_t2_kwh(8583.995)
                    .active_power_w(getRandomMeasurement(1D, 1000D))
                    .active_power_l1_w(1245.0)
                    .active_power_l2_w(0.0)
                    .total_gas_m3(getRandomMeasurement(30000D, 50000D))
                    .gas_timestamp(new Timestamp(System.currentTimeMillis()).getTime())
                    .active_liter_lpm(0.0)
                    .build());
            });

        return Flux.interval(Duration.ofMillis(1000))
                .zipWith(eventFlux, (time, event) -> event);
    }

    public Double getRandomMeasurement(Double leftLimit, Double rightLimit) {
        Double activemeasurement =  leftLimit  + (double) (Math.random() * (rightLimit - leftLimit));
        return activemeasurement;
    }

}
