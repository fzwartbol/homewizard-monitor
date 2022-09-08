package com.frederik.homewizardenergyapiconsumer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class represents a measurement from the HomeWizard Energy API.
 * see https://homewizard-energy-api.readthedocs.io/endpoints.html
 * @author Frederik
 */
@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    @Id
    private String id;
    private Long measuredTime;

    private Integer smr_version;
    private String meter_model;
    private String wifi_ssid;
    private Integer wifi_strength;
    private Double total_power_import_t1_kwh;
    private Double total_power_import_t2_kwh;
    private Double total_power_export_t1_kwh;
    private Double total_power_export_t2_kwh;
    private Double active_power_w;
    private Double active_power_l1_w;
    private Double active_power_l2_w;
    private Double total_gas_m3;
    private Long gas_timestamp;
    private Double active_liter_lpm;
    private Double total_liter_m3;

    public Measurement(double v) {
        this.active_power_w = v;
    }
}

