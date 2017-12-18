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
public class Employee {

    private Integer id;    
  
    private String name;
   
    private String phone;
    
    private Float salary;
    
    public Employee(Integer id, String name, String phone, Float salary){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the salary
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }
    
    
}
