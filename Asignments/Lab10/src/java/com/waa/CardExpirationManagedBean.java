/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class CardExpirationManagedBean {
    private Integer month, year;
    /**
     * Creates a new instance of CardExpirationManagedBean
     */
    public CardExpirationManagedBean() {       
        this.month = 1;
        this.year = 1900;
    }    

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String submit(){
        return "result.xhtml";
    }   
    public String tryagain(){
        return "index.xhtml";
    }

}
