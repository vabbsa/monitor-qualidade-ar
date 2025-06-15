package com.airquality.monitor.service;

import com.airquality.monitor.model.AirQualityData;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AirQualityService {
    
    private final WebClient webClient;
    private final Random random = new Random();
    
    private final Map<String, Double[]> cityCoordinates = new HashMap<>();
    
    public AirQualityService() {
        this.webClient = WebClient.builder().build();
        initializeCityCoordinates();
    }
    
    private void initializeCityCoordinates() {
        cityCoordinates.put("São Paulo", new Double[]{-23.5505, -46.6333});
        cityCoordinates.put("Rio de Janeiro", new Double[]{-22.9068, -43.1729});
        cityCoordinates.put("Belo Horizonte", new Double[]{-19.9167, -43.9345});
        cityCoordinates.put("Salvador", new Double[]{-12.9714, -38.5014});
        cityCoordinates.put("Brasília", new Double[]{-15.7939, -47.8828});
        cityCoordinates.put("Curitiba", new Double[]{-25.4284, -49.2733});
        cityCoordinates.put("Fortaleza", new Double[]{-3.7172, -38.5433});
        cityCoordinates.put("Manaus", new Double[]{-3.1190, -60.0217});
        cityCoordinates.put("Recife", new Double[]{-8.0476, -34.8770});
        cityCoordinates.put("Porto Alegre", new Double[]{-30.0346, -51.2177});
    }
    
    public Mono<AirQualityData> getAirQualityData(String city) {
        
        return Mono.fromCallable(() -> generateSimulatedData(city));
    }
    
    private AirQualityData generateSimulatedData(String city) {
        AirQualityData data = new AirQualityData(city);
        
        int baseAqi = getCityBaseAqi(city);
        int variation = random.nextInt(41) - 20; 
        int finalAqi = Math.max(1, Math.min(500, baseAqi + variation));
        
        data.setAqi(finalAqi);
        data.setPm25(generatePm25FromAqi(finalAqi));
        data.setPm10(generatePm10FromAqi(finalAqi));
        data.setO3(generateO3FromAqi(finalAqi));
        data.setNo2(generateNo2FromAqi(finalAqi));
        data.setSo2(generateSo2FromAqi(finalAqi));
        data.setCo(generateCoFromAqi(finalAqi));
        
        data.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        data.calculateStatus();
        
        return data;
    }
    
    private int getCityBaseAqi(String city) {
        
        String cityLower = city.toLowerCase();
        if (cityLower.equals("são paulo")) {
            return 85;
        } else if (cityLower.equals("rio de janeiro")) {
            return 75;
        } else if (cityLower.equals("belo horizonte")) {
            return 70;
        } else if (cityLower.equals("salvador")) {
            return 60;
        } else if (cityLower.equals("brasília")) {
            return 65;
        } else if (cityLower.equals("curitiba")) {
            return 55;
        } else if (cityLower.equals("fortaleza")) {
            return 50;
        } else if (cityLower.equals("manaus")) {
            return 45;
        } else if (cityLower.equals("recife")) {
            return 65;
        } else if (cityLower.equals("porto alegre")) {
            return 60;
        } else {
            return 70;
        }
    }
    
    private Double generatePm25FromAqi(int aqi) {
        
        if (aqi <= 50) return random.nextDouble() * 12;
        if (aqi <= 100) return 12 + random.nextDouble() * 23;
        if (aqi <= 150) return 35 + random.nextDouble() * 20;
        if (aqi <= 200) return 55 + random.nextDouble() * 95;
        return 150 + random.nextDouble() * 100;
    }
    
    private Double generatePm10FromAqi(int aqi) {
        
        Double pm25 = generatePm25FromAqi(aqi);
        return pm25 * (1.5 + random.nextDouble() * 0.5);
    }
    
    private Double generateO3FromAqi(int aqi) {
        
        if (aqi <= 50) return random.nextDouble() * 100;
        if (aqi <= 100) return 100 + random.nextDouble() * 68;
        if (aqi <= 150) return 168 + random.nextDouble() * 40;
        return 208 + random.nextDouble() * 100;
    }
    
    private Double generateNo2FromAqi(int aqi) {
        
        if (aqi <= 50) return random.nextDouble() * 40;
        if (aqi <= 100) return 40 + random.nextDouble() * 40;
        if (aqi <= 150) return 80 + random.nextDouble() * 40;
        return 120 + random.nextDouble() * 80;
    }
    
    private Double generateSo2FromAqi(int aqi) {
        
        if (aqi <= 50) return random.nextDouble() * 20;
        if (aqi <= 100) return 20 + random.nextDouble() * 60;
        if (aqi <= 150) return 80 + random.nextDouble() * 120;
        return 200 + random.nextDouble() * 100;
    }
    
    private Double generateCoFromAqi(int aqi) {
        
        if (aqi <= 50) return random.nextDouble() * 4;
        if (aqi <= 100) return 4 + random.nextDouble() * 5;
        if (aqi <= 150) return 9 + random.nextDouble() * 6;
        return 15 + random.nextDouble() * 15;
    }
}

