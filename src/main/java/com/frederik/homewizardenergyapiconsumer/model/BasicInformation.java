package com.frederik.homewizardenergyapiconsumer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class BasicInformation {
        @Id
        private Long id;
        private String product_type;
        private String product_name;
        private String serial;
        private String firmware_version;
        private String api_version;
}
