/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hangha
 */
@FacesConverter("TemperatureConverter")
public class TemperatureConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if ("".equals(string)) {
            return null;
        }

        String temptype = string.substring(0, 1);
        String tempvalue = string.substring(1);
        Temperature temp = new Temperature(tempvalue, temptype);
        return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Temperature temp = (Temperature) o;

        if (temp.getTemperatureType().equals("F")) {
            return temp.getTemperature() + " Fahrenheit";
        } else {
            return temp.getTemperature() + " Celcius";
        }
    }

}
