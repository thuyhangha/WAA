/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa.model;

/**
 *
 * @author hangha
 */
public class Person {

    private Integer key;
    private String firstName;
    private String lastName;

    public Person(Integer key, String firstName, String lastName) {
        super();
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
