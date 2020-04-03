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
@Stateless
public class BaseballCoach implements Coach{

    @Override
    public String instruct() {
        return "Take 300 swings";
    }

    
}
