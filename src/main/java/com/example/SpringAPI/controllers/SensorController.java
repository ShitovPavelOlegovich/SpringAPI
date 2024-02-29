package com.example.SpringAPI.controllers;

import com.example.SpringAPI.dto.SensorDTO;
import com.example.SpringAPI.models.Sensor;
import com.example.SpringAPI.repositories.SensorRepository;
import com.example.SpringAPI.services.SensorService;
import com.example.SpringAPI.validators.SensorNameValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorNameValidator sensorNameValidator;
    private final ModelMapper modelMapper;
    private final SensorRepository sensorRepository;


    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        sensorNameValidator.validate(sensorDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        sensorService.registrationSensor(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

}
