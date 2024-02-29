package com.example.SpringAPI.services;

import com.example.SpringAPI.models.Sensor;
import com.example.SpringAPI.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<Sensor> findAllSensor() {
       return sensorRepository.findAll();
    }

    public Sensor findOneSensor(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Transactional
    public void registrationSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
