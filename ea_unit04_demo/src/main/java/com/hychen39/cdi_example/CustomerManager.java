/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hychen39.cdi_example;;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * A CDI Bean with the request scope.
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "manager")
@RequestScoped
public class CustomerManager {
     @Inject
    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String confirmCustomer() {
        //code to save customer information in database
        return "success";
    }
}
