/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class HelloManagedBean {
    private String name;
    /**
     * Creates a new instance of HelloManagedBean
     */
    public HelloManagedBean() {
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
    
    public String sayHello() {
        return null;
    }
}
