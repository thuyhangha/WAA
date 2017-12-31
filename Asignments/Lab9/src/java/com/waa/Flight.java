/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.Date;

/**
 *
 * @author hangha
 */
public class Flight {

    private String fromCity;
    private String toCity;
    private Date date;
    private String airline;
    private Float price;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Flight(String fromCity, String toCity, Date date, String airline, Float price) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
        this.airline = airline;
        this.price = price;
    }
}
