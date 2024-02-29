package com.example.SpringAPI.exceptions;

public class RainyDaysCountNotFoundException extends RuntimeException{

    public RainyDaysCountNotFoundException() {
        super("Rainy days not found");
    }
}
