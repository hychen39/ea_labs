/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeserviceclient.standard;

import ejb.session.TimeServiceRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author steven
 */
public class TimeServiceClientStandard {

    /**
     * @param args the command line arguments
     */
    private static TimeServiceRemote tsr;
    public static void main(String[] args) throws NamingException {
        InitialContext ic = new InitialContext();
        // ejb3.session.TimeServiceRemote
        tsr = (TimeServiceRemote) ic.lookup(TimeServiceRemote.class.getName());
        String timeStr = tsr.getTime();
        System.out.printf("The current time is: %s\n",timeStr);
    }
    
}
