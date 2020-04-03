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
@Stateless(name="runningCoach")
public class RunningCoach implements Coach {

    @Override
    public String instruct() {
        return "Run a hard 5k";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
