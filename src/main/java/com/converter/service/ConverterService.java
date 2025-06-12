package com.converter.service;

import org.springframework.stereotype.Service;
import java.text.DecimalFormat;

@Service
public class ConverterService {

    // Length conversion factors to meters
    private final double MM_TO_M = 0.001;
    private final double CM_TO_M = 0.01;
    private final double KM_TO_M = 1000;
    private final double INCH_TO_M = 0.0254;
    private final double FOOT_TO_M = 0.3048;
    private final double YARD_TO_M = 0.9144;
    private final double MILE_TO_M = 1609.344;

    // Weight conversion factors to grams
    private final double MG_TO_G = 0.001;
    private final double KG_TO_G = 1000;
    private final double OUNCE_TO_G = 28.3495;
    private final double POUND_TO_G = 453.592;

    public double convertLength(double value, String fromUnit, String toUnit) {
        // Convert from input unit to meters
        double meters = switch (fromUnit) {
            case "millimeter" -> value * MM_TO_M;
            case "centimeter" -> value * CM_TO_M;
            case "meter" -> value;
            case "kilometer" -> value * KM_TO_M;
            case "inch" -> value * INCH_TO_M;
            case "foot" -> value * FOOT_TO_M;
            case "yard" -> value * YARD_TO_M;
            case "mile" -> value * MILE_TO_M;
            default -> value;
        };

        // Convert from meters to output unit
        return switch (toUnit) {
            case "millimeter" -> meters / MM_TO_M;
            case "centimeter" -> meters / CM_TO_M;
            case "meter" -> meters;
            case "kilometer" -> meters / KM_TO_M;
            case "inch" -> meters / INCH_TO_M;
            case "foot" -> meters / FOOT_TO_M;
            case "yard" -> meters / YARD_TO_M;
            case "mile" -> meters / MILE_TO_M;
            default -> meters;
        };
    }

    public double convertWeight(double value, String fromUnit, String toUnit) {
        // Convert from input unit to grams
        double grams = switch (fromUnit) {
            case "milligram" -> value * MG_TO_G;
            case "gram" -> value;
            case "kilogram" -> value * KG_TO_G;
            case "ounce" -> value * OUNCE_TO_G;
            case "pound" -> value * POUND_TO_G;
            default -> value;
        };

        // Convert from grams to output unit
        return switch (toUnit) {
            case "milligram" -> grams / MG_TO_G;
            case "gram" -> grams;
            case "kilogram" -> grams / KG_TO_G;
            case "ounce" -> grams / OUNCE_TO_G;
            case "pound" -> grams / POUND_TO_G;
            default -> grams;
        };
    }

    public double convertTemperature(double value, String fromUnit, String toUnit) {
        // First convert to Kelvin
        double kelvin = switch (fromUnit) {
            case "Celsius" -> value + 273.15;
            case "Fahrenheit" -> (value + 459.67) * 5/9;
            case "Kelvin" -> value;
            default -> value;
        };

        // Then convert from Kelvin to target unit
        return switch (toUnit) {
            case "Celsius" -> kelvin - 273.15;
            case "Fahrenheit" -> kelvin * 9/5 - 459.67;
            case "Kelvin" -> kelvin;
            default -> kelvin;
        };
    }
}