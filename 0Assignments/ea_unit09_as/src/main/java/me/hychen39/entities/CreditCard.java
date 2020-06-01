/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hychen39.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Credit Card domain object.
 * @author steven
 */
public class CreditCard implements Serializable{

    public CreditCard() {
        this.type = CardType.AmericanExpress;
    }
    
    public static enum CardType {
        AmericanExpress("AE", "American Express"), 
        DinnerClub("DC", "Dinner Club"), 
        MasterCard("MC", "Master Card"), 
        VISA("VS", "VISA");
        private String code;
        private String desc;

        private CardType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        private CardType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        
        
        
        
    }
    private String cardNumber;
    private String name;
    private CardType type;
    private Date expiredDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }


    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
}
