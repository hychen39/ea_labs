/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless(name="swimmingCoach")
public class SwimmingCoach implements Coach {

    @Override
    public String instruct() {
        return "Swimming 2k";
    }
    
    
}
