package com.frederikzwartbol.sensormockdemo.model;

import lombok.Builder;
import lombok.Data;

/**
 * This class represents a mock measurement from a sensor.
 */

@Data
@Builder
public class Measurement {
    private final Integer smr_version;
    private final String meter_model;
    private final String wifi_ssid;
    private final Integer wifi_strength;
    private final Double total_power_import_t1_kwh;
    private final Double total_power_import_t2_kwh;
    private final Double total_power_export_t1_kwh;
    private final Double total_power_export_t2_kwh;
    private final Double active_power_w;
    private final Double active_power_l1_w;
    private final Double active_power_l2_w;
    private final Double total_gas_m3;
    private final Long gas_timestamp;
    private final Double active_liter_lpm;
    private final Double total_liter_m3;
}

