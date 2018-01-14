/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.PhaseEvent;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class SearchManagedBean {
    private String searchItem;
    private List<String> countries;
    /**
     * Creates a new instance of SearchManagedBean
     */
    public SearchManagedBean() {
        this.countries = new ArrayList<>();
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("American Samoa");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Anguilla");
        countries.add("Antarctica");
        countries.add("Antigua and Barbuda");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Aruba");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");   
    }
    
    /**
     * @return the searchItem
     */
    public String getSearchItem() {
        return searchItem;
    }

    /**
     * @param searchItem the searchItem to set
     */
    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    /**
     * @return the countries
     */
    public List<String> getCountries() {
        if (searchItem != null && !searchItem.equals("")) {
            return countries.stream().filter(x -> x.toLowerCase().startsWith(searchItem.toLowerCase())).collect(Collectors.toList());
        }
        return countries;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
   
    public void phaseListener(PhaseEvent e) {
        System.out.println(e);
    }
}
