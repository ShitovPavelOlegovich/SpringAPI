package com.example.SpringAPI.exceptions;

public class MeasurementNotFoundException extends RuntimeException{

    public MeasurementNotFoundException() {
        super("Measurement not found");
    }
}
