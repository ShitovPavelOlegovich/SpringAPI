package com.example.SpringAPI.controllers;

import com.example.SpringAPI.dto.MeasurementDTO;

import com.example.SpringAPI.models.Measurement;
import com.example.SpringAPI.services.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;



    @GetMapping()
    public ResponseEntity<List<MeasurementDTO>> findAllMeasurement() {
        List<MeasurementDTO> measurementDTOS =
                measurementService.findAllMeasurement().stream().map(this::convertToMeasurementDTO)
                        .collect(Collectors.toList());
        return new ResponseEntity<>(measurementDTOS, HttpStatus.OK);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Integer> findAllRainyDaysCount() {
        int rainyDaysCount = measurementService.findAllRainyDaysCount();
        return new ResponseEntity<>(rainyDaysCount, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        measurementService.createMeasurement(convertToMeasurement(measurementDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }


}
