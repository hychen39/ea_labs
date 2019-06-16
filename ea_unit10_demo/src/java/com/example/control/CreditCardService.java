/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.CreditCard;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author steven
 */
@Named
@SessionScoped
public class CreditCardService implements Serializable {

    private ArrayList<SelectItem> acceptCardType;

    public ArrayList<SelectItem> getAcceptCardType() {
        return acceptCardType;
    }

    public void setAcceptCardType(ArrayList<SelectItem> acceptCardType) {
        this.acceptCardType = acceptCardType;
    }

    /**
     * Create a credit card using data from flash scope. The new credit card
     * object will be stored in the session scope.
     *
     * @return navigation string
     */
    public String createCard() {
        String tgtPage = "index";
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        String cardNum = (String) flash.get("cardNumber");
        String name = (String) flash.get("cardHolder");
        String type = (String) flash.get("cardType");
        Date expiredDate = (Date) flash.get("expiredDate");

        CreditCard card = new CreditCard(cardNum);
        card.setType(type);
        card.setName(name);
        card.setExpiredDate(expiredDate);

        // Store in the session scope.
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("creditCard", card);

        return tgtPage;
    }

    @PostConstruct
    public void initCardType() {
        acceptCardType = new ArrayList<SelectItem>();
        acceptCardType.add(new SelectItem("AE", "American Express"));
        acceptCardType.add(new SelectItem("DC", "Dinner Club"));
        acceptCardType.add(new SelectItem("MC", "MasterCard"));
        acceptCardType.add(new SelectItem("VS", "VISA"));
    }
    
    public Date getCurrentDateTime(){
        LocalDateTime currentDateTime =  LocalDateTime.now();
        ZoneId twZoneId = ZoneId.of("+08:00");
        return java.util.Date.from(currentDateTime.atZone(twZoneId).toInstant());
        
    }
    
    public Date getCurrentDateTimeNoTZ(){
        return new Date();
    }
    
    public double getRandNumber(){
        return Math.random() * 1000000;
    }
}
