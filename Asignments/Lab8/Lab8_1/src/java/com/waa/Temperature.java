/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

/**
 *
 * @author hangha
 */
public class Temperature {
    private String temperature;
    private String temperatureType;
    
    public  Temperature (String temperature, String temperatureType) {
        this.temperature = temperature;
        this.temperatureType = temperatureType;
    }
    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the temperatureType
     */
    public String getTemperatureType() {
        return temperatureType;
    }

    /**
     * @param temperatureType the temperatureType to set
     */
    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }       
    
}
