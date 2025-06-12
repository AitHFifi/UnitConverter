package com.converter.controller;

import com.converter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/length")
    public String lengthConverter() {
        return "length";
    }

    @PostMapping("/length")
    public String convertLength(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnit,
            @RequestParam("toUnit") String toUnit,
            Model model) {
        
        double result = converterService.convertLength(value, fromUnit, toUnit);
        
        model.addAttribute("value", value);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit);
        model.addAttribute("result", result);
        
        return "length";
    }

    @GetMapping("/weight")
    public String weightConverter() {
        return "weight";
    }

    @PostMapping("/weight")
    public String convertWeight(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnit,
            @RequestParam("toUnit") String toUnit,
            Model model) {
        
        double result = converterService.convertWeight(value, fromUnit, toUnit);
        
        model.addAttribute("value", value);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit);
        model.addAttribute("result", result);
        
        return "weight";
    }

    @GetMapping("/temperature")
    public String temperatureConverter() {
        return "temperature";
    }

    @PostMapping("/temperature")
    public String convertTemperature(
            @RequestParam("value") double value,
            @RequestParam("fromUnit") String fromUnit,
            @RequestParam("toUnit") String toUnit,
            Model model) {
        
        double result = converterService.convertTemperature(value, fromUnit, toUnit);
        
        model.addAttribute("value", value);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit);
        model.addAttribute("result", result);
        
        return "temperature";
    }
}