package com.frederik.homewizardenergyapiconsumer.utils;

import com.frederik.homewizardenergyapiconsumer.model.dto.MeasurementDTO;
import com.frederik.homewizardenergyapiconsumer.model.entity.Measurement;
import org.springframework.beans.BeanUtils;

public class ModelMapper {

    public static Measurement dtoToEntity(MeasurementDTO measurementDTO) {
        Measurement measurement = new Measurement();
        BeanUtils.copyProperties(measurementDTO, measurement);
        return measurement;
    }

    public static MeasurementDTO entityToDto(Measurement measurement) {
        MeasurementDTO measurementDTO = new MeasurementDTO();
        BeanUtils.copyProperties(measurement, measurementDTO);
       return measurementDTO;
    }
}