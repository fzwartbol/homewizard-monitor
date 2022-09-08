package com.frederikzwartbol.sensormockdemo.model;

import lombok.Data;

@Data
public class BasicInformation {
        private Long id;
        private String product_type;
        private String product_name;
        private String serial;
        private String firmware_version;
        private String api_version;
}
