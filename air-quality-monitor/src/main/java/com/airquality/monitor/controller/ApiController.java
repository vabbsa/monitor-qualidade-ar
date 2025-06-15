package com.airquality.monitor.controller;

import com.airquality.monitor.model.AirQualityData;
import com.airquality.monitor.model.Tip;
import com.airquality.monitor.service.AirQualityService;
import com.airquality.monitor.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {
    
    @Autowired
    private AirQualityService airQualityService;
    
    @Autowired
    private TipService tipService;
    
    @GetMapping("/air-quality/{city}")
    public Mono<ResponseEntity<AirQualityData>> getAirQuality(@PathVariable String city) {
        return airQualityService.getAirQualityData(city)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/tips")
    public ResponseEntity<List<Tip>> getAllTips() {
        return ResponseEntity.ok(tipService.getAllTips());
    }
    
    @GetMapping("/tips/{category}")
    public ResponseEntity<List<Tip>> getTipsByCategory(@PathVariable String category) {
        List<Tip> tips = tipService.getTipsByCategory(category);
        return ResponseEntity.ok(tips);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API está funcionando!");
    }
}

