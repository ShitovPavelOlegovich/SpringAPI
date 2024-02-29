package com.example.SpringAPI.dto;


import com.example.SpringAPI.models.Sensor;
import lombok.Data;

@Data
public class MeasurementDTO {
    private double value;
    private boolean raining;
    private Sensor ownerSensor;

}
