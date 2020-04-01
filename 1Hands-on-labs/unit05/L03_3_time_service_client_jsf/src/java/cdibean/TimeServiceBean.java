/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibean;

import ejb.session.TimeServiceRemote;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "timeServiceBean")
@RequestScoped
public class TimeServiceBean {
    @EJB
    TimeServiceRemote timeServiceRemote;
    /**
     * Creates a new instance of TimeServiceBean
     */
    public TimeServiceBean() {
    }
    
    public String getCurrentTime(){
        return timeServiceRemote.getTime();
    }
}
