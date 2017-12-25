/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class TemperatureManagedBean {

    /**
     * Creates a new instance of TemperatureManagedBean
     */
    public TemperatureManagedBean() {
    }
    private Date date = new Date();
    private Temperature temp = null;

    public String showresult() {
        return "result";
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

}
