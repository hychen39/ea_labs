/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Card Number converter. 
 * Users are allowed to enter the card numbers with or without "-" or space.
 * @author steven
 */
@FacesConverter("com.example.converter.CardNumberConverter")
public class CardNumberConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String cardNumStr = value.replaceAll("[-\\s]+", "");
        return cardNumStr;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String inputVal = (String) value;
        char [] input = inputVal.toCharArray();
        StringBuffer bf = new StringBuffer();
        for(int i=0 ; i<input.length ; i++){
            if ((i%4) == 0 && i !=0){
                bf.append("-");
            }
            bf.append(input[i]);
        }
        return bf.toString();
    }
    
}
