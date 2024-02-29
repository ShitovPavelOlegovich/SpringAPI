package com.example.SpringAPI.validators;

import com.example.SpringAPI.dto.SensorDTO;
import com.example.SpringAPI.models.Sensor;
import com.example.SpringAPI.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SensorNameValidator implements Validator {

    private final SensorRepository sensorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;
        if (sensorRepository.findByName(sensorDTO.getName()).isPresent()) {
            errors.rejectValue("name", "", "Сенсор с таким именем уже существует");
        }

    }
}
