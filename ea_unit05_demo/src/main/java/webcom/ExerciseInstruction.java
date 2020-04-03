/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcom;

import ejb.Coach;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author user
 */
@Named(value = "exerciseInstruction")
@RequestScoped
public class ExerciseInstruction {

    @EJB(beanName = "runningCoach")
    Coach runningCoach;

    @EJB(beanName = "swimmingCoach")
    Coach swimmingCoach;

    Coach baseballCoach;

    @PostConstruct
    public void init() {
        Context jndiContext;
        try {
            jndiContext = new InitialContext();
            String targetEJBNameFull = "java:global/ea_unit05_demo/BaseballCoach!ejb.Coach";
            String targetEJBNameApp = "java:app/ea_unit05_demo/BaseballCoach";
            String targetEJBNameModule = "java:module/BaseballCoach";
            this.baseballCoach = (Coach) jndiContext.lookup(targetEJBNameModule);
        } catch (NamingException ex) {
            Logger.getLogger(ExerciseInstruction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new instance of ExerciseInstruction
     */
    public ExerciseInstruction() {
    }

    public String getRunningCoachInstruction() {
        return runningCoach.instruct();
    }

    public String getSwimmingCoachInstruction() {
        return swimmingCoach.instruct();
    }
    
    public String getBaseballCoachInstruction(){
        return this.baseballCoach.instruct();
    }
}
