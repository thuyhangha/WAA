/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author hangha
 */
@FacesValidator("priceValidator")
public class PriceValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null) {
            return;
        }
        
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        
        String value = o.toString();
        Integer price;
        
        try {
            price = Integer.parseInt(value);
            if (price < 1) {
                message.setDetail("The value \"" + price + "\" is smaller than the minimum value of 1.");
                throw new ValidatorException(message);
            } else if (price > 100000) {
                message.setDetail("The value \"" + price + "\" is larger than the maximum value of 100000.");
                throw new ValidatorException(message);
            }
        } catch (NumberFormatException ex) {
            message.setDetail("Invalid number format");
            throw new ValidatorException(message);
        }
    }
    
}
