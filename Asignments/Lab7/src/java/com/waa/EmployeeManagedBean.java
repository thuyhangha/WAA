/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class EmployeeManagedBean {

    /**
     * Creates a new instance of EmployeeManagedBean
     */
    private String title;
    
    private Employee selectedEmployee;
     
    public EmployeeManagedBean(){
        this.selectedEmployee = this.getLstEmployee().get(0);
        this.title = "Home";
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public Employee getSelectedEmployee() {
        return this.selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }    
    public String index(){        
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer selectedId = Integer.parseInt(params.get("selectedId"));
        String selectedName = params.get("selectedName");
        String selectedPhone = params.get("selectedPhone");
        Float selectedSalary = Float.parseFloat(params.get("selectedSalary"));
        
        this.selectedEmployee.setId(selectedId);
        this.selectedEmployee.setName(selectedName);
        this.selectedEmployee.setPhone(selectedPhone);
        this.selectedEmployee.setSalary(selectedSalary);
                
        this.title = selectedName + " Details";      
        
        return "index";
    }
    
    public String showall(){
        this.title = "All Employees";
        return "show_all_employee";
    }    
    
    private List<Employee> lstEmployee;
    public List<Employee> getLstEmployee(){
        this.lstEmployee = new ArrayList<>();
        lstEmployee.add(new Employee(1432, "Frank Brown","625-345-2635",45089.5F));
        lstEmployee.add(new Employee(1321, "John Doe","625-345-3321",56003.0F));
        lstEmployee.add(new Employee(1634, "Marry Jones","625-345-3421",73998.3F));
        
        return lstEmployee;
    }
    public void setLstEmployee(List<Employee> lstEmployee){
        this.lstEmployee = lstEmployee;
    }
    
}
