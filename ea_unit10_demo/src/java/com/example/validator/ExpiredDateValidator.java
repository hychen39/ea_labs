/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.validator;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author steven
 */
@FacesValidator("com.example.ExpiredDateValidator")
public class ExpiredDateValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Date enteredDate = null;
        Calendar cal = Calendar.getInstance();
        
        try {
            if (value != null){
            enteredDate = (Date) value;
            } else {
                throw new ValidatorException(new FacesMessage("Please provide the expired date."));
            }
            cal.setTime(enteredDate);
        } catch (ClassCastException e) {
            // Output Error Message: Require to use f:ConvertDateTime
            String message = "Require to use f:ConvertDateTime";
            ((UIInput) component).setValid(false);
            throw new ValidatorException(new FacesMessage(message));
        }
        
        int year = cal.get(Calendar.YEAR);
        if (year < 2015 || year > 2025 ) {
            // validate failed. Show error mssage
            String message = "The year should be between 2015 and 2025";
            ((UIInput) component).setValid(false);
            // add message
            context.addMessage(component.getClientId(), new FacesMessage(message));
        }
    }
    
}
