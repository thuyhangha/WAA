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
public class CalculateManagedBean {

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }
    private int firstNumber;
    private int secondNumber;
    private int result;
    
    /**
     * Creates a new instance of CalculateManagedBean
     */
    public CalculateManagedBean() {
    }
    /**
     * @return the firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
    
    public void add()
    {
        this.setResult(firstNumber + secondNumber);
    }

    public void subtract()
    {
        this.setResult(firstNumber - secondNumber);
    }

     public void multiply()
    {
        this.setResult(firstNumber * secondNumber);
    }

    public void divide()
    {
         if(firstNumber == 0 || secondNumber ==0)
         {
             this.setResult(0);
         }
        else
         {
             this.setResult(firstNumber / secondNumber);
        }

    }
 
}
