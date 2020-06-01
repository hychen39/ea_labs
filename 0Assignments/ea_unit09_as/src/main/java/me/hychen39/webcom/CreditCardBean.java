/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hychen39.webcom;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import me.hychen39.entities.CreditCard;

/**
 *
 * @author steven
 */
@Named
@SessionScoped
public class CreditCardBean implements Serializable {
    
    /**
     * Field to save the form data
     */
    private CreditCard creditCard;

    public List<CreditCard.CardType> getAvailableCardTypes() {
        return Arrays.asList(CreditCard.CardType.values());
    }
   
    
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    
    /**
     * Create a credit card and store it in the current session.
     *
     * @return navigation string
     */
    public String createCard() {
        String tgtPage = "index";
        // Store in the session scope.
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("creditCard", this.creditCard);
        this.creditCard = new CreditCard();
        return tgtPage;
    }

    @PostConstruct
    public void init() {
        this.creditCard = new CreditCard();
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
