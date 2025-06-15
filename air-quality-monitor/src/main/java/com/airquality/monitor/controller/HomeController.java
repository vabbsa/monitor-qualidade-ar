package com.airquality.monitor.controller;

import com.airquality.monitor.model.AirQualityData;
import com.airquality.monitor.service.AirQualityService;
import com.airquality.monitor.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private AirQualityService airQualityService;
    
    @Autowired
    private TipService tipService;
    
    private final List<String> availableCities = Arrays.asList(
        "São Paulo", "Rio de Janeiro", "Belo Horizonte", "Salvador", 
        "Brasília", "Curitiba", "Fortaleza", "Manaus", "Recife", "Porto Alegre"
    );
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cities", availableCities);
        return "index";
    }
    
    @PostMapping("/search")
    public String searchAirQuality(@RequestParam("city") String city, Model model) {
        model.addAttribute("cities", availableCities);
        model.addAttribute("selectedCity", city);
        
        try {
            Mono<AirQualityData> airQualityMono = airQualityService.getAirQualityData(city);
            AirQualityData airQualityData = airQualityMono.block();
            model.addAttribute("airQualityData", airQualityData);
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao buscar dados de qualidade do ar para " + city);
        }
        
        return "index";
    }
    
    @GetMapping("/tips")
    public String tips(Model model) {
        model.addAttribute("tips", tipService.getAllTips());
        return "tips";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

