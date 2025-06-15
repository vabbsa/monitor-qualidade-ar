package com.airquality.monitor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirQualityData {
    
    @JsonProperty("aqi")
    private Integer aqi;
    
    @JsonProperty("pm25")
    private Double pm25;
    
    @JsonProperty("pm10")
    private Double pm10;
    
    @JsonProperty("o3")
    private Double o3;
    
    @JsonProperty("no2")
    private Double no2;
    
    @JsonProperty("so2")
    private Double so2;
    
    @JsonProperty("co")
    private Double co;
    
    private String city;
    private String status;
    private String healthRecommendation;
    private String timestamp;
    
    // Construtores
    public AirQualityData() {}
    
    public AirQualityData(String city) {
        this.city = city;
    }
    
    // Getters e Setters
    public Integer getAqi() {
        return aqi;
    }
    
    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }
    
    public Double getPm25() {
        return pm25;
    }
    
    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }
    
    public Double getPm10() {
        return pm10;
    }
    
    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }
    
    public Double getO3() {
        return o3;
    }
    
    public void setO3(Double o3) {
        this.o3 = o3;
    }
    
    public Double getNo2() {
        return no2;
    }
    
    public void setNo2(Double no2) {
        this.no2 = no2;
    }
    
    public Double getSo2() {
        return so2;
    }
    
    public void setSo2(Double so2) {
        this.so2 = so2;
    }
    
    public Double getCo() {
        return co;
    }
    
    public void setCo(Double co) {
        this.co = co;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getHealthRecommendation() {
        return healthRecommendation;
    }
    
    public void setHealthRecommendation(String healthRecommendation) {
        this.healthRecommendation = healthRecommendation;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    // Método para determinar o status baseado no AQI
    public void calculateStatus() {
        if (aqi == null) {
            this.status = "Dados não disponíveis";
            this.healthRecommendation = "Não foi possível obter dados de qualidade do ar.";
            return;
        }
        
        if (aqi <= 50) {
            this.status = "Boa";
            this.healthRecommendation = "A qualidade do ar é considerada satisfatória e a poluição do ar representa pouco ou nenhum risco.";
        } else if (aqi <= 100) {
            this.status = "Moderada";
            this.healthRecommendation = "A qualidade do ar é aceitável para a maioria das pessoas. Pessoas sensíveis podem apresentar sintomas menores.";
        } else if (aqi <= 150) {
            this.status = "Insalubre para grupos sensíveis";
            this.healthRecommendation = "Pessoas com doenças respiratórias, cardíacas, crianças e idosos podem apresentar sintomas.";
        } else if (aqi <= 200) {
            this.status = "Insalubre";
            this.healthRecommendation = "Todos podem começar a apresentar problemas de saúde. Grupos sensíveis podem ter efeitos mais sérios.";
        } else if (aqi <= 300) {
            this.status = "Muito insalubre";
            this.healthRecommendation = "Alerta de saúde: todos podem apresentar efeitos mais sérios à saúde.";
        } else {
            this.status = "Perigosa";
            this.healthRecommendation = "Alerta de emergência: toda a população tem maior probabilidade de ser afetada.";
        }
    }
}

