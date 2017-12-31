/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class FlightManagedBean {
    private List<Flight> allFlights;

    private List<Flight> flightsByAirline;

    /**
     * Creates a new instance of FlightManagedBean
     */
    public FlightManagedBean() {
        this.allFlights = new ArrayList<>();

        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)) , "KLM", 790.80F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "NorthWest", 795.55F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "KLM", 820.00F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "United Airlines", 825.50F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "NorthWest", 875.00F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "KLM", 989.00F));
        this.allFlights.add(new Flight("Amsterdam", "New York", Date.valueOf(LocalDate.of(2006, 12, 11)), "United Airlines", 1050.00F));

        this.flightsByAirline = this.allFlights;
    }
    
    
    public List<Flight> getAllFlights() {
        return allFlights;
    }

    public void setAllFlights(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public List<Flight> getFlightsByAirline() {
        return flightsByAirline;
    }

    public void setFlightsByAirline(List<Flight> flightsByAirline) {
        this.flightsByAirline = flightsByAirline;
    }
    
    public void airlineChanged(ValueChangeEvent event) {
        String selectedAirline = event.getNewValue().toString();
        if (selectedAirline.toUpperCase().equals("ALL")) {
            this.flightsByAirline = this.allFlights;
        } else {
            this.flightsByAirline = this.allFlights.stream()
                    .filter(flight -> flight.getAirline().equals(selectedAirline))
                    .map(flight -> flight)
                    .collect(Collectors.toList());
        }

    }
}
