/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hychen39.cdi_example;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * A CDI bean for modeling a customer. The bean is of session scope.
 * @author admin
 */
@Named(value = "customer")
@SessionScoped
public class Customer implements java.io.Serializable{
    private String firstName;
    private String lastName;
    private String email;
    
    public Customer() {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
