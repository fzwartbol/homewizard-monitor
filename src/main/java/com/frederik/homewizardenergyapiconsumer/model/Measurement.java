package com.frederik.homewizardenergyapiconsumer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class represents a measurement from the HomeWizard Energy API.
 * see https://homewizard-energy-api.readthedocs.io/endpoints.html
 * @author Frederik
 */
@Document
@Data
public class Measurement {
    @Id
    private Long id;
    private Long smr_version;
    private String meter_model;
    private String wifi_ssid;
    private Long wifi_strength;
    private Long total_power_import_t1_kwh;
    private Long total_power_import_t2_kwh;
    private Long total_power_export_t1_kwh;
    private Long total_power_export_t2_kwh;
    private Long active_power_w;
    private Long active_power_l1_w;
    private Long active_power_l2_w;
    private Long total_gas_m3;
    private Long gas_timestamp;
    private Long active_liter_lpm;
    private Long total_liter_m3;
}

