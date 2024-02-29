package com.example.SpringAPI.services;

import com.example.SpringAPI.exceptions.MeasurementNotFoundException;
import com.example.SpringAPI.exceptions.RainyDaysCountNotFoundException;
import com.example.SpringAPI.models.Measurement;
import com.example.SpringAPI.models.Sensor;
import com.example.SpringAPI.repositories.MeasurementRepository;
import com.example.SpringAPI.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;


    public List<Measurement> findAllMeasurement() {
        List<Measurement> measurements = measurementRepository.findAll();
        if (measurements.isEmpty()) {
            throw new MeasurementNotFoundException();
        }
        return measurements;
    }

    public int findAllRainyDaysCount() {
        List<Measurement> rainyDaysMeasurements = measurementRepository.findByRainingIsTrue();
        if (rainyDaysMeasurements.isEmpty()) {
            throw new RainyDaysCountNotFoundException();
        }
        return rainyDaysMeasurements.size();
    }

    @Transactional
    public void createMeasurement(Measurement measurement) {
        Sensor sensor = measurement.getOwnerSensor();
        Optional<Sensor> existingSensor = sensorRepository.findByName(sensor.getName());

        if (existingSensor.isPresent()) {
            measurement.setOwnerSensor(existingSensor.get());
        } else {
            sensorRepository.save(sensor);
        }

        measurementRepository.save(measurement);
    }

}
