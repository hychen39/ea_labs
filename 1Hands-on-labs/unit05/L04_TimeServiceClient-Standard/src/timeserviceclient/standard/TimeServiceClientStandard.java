package timeserviceclient.standard;

import ejb.session.TimeServiceRemote;
import javax.naming.Context;
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
        Context ic = new InitialContext();
        // ejb3.session.TimeServiceRemote
        String targetEJBName = "java:global/L03_2_time_service_ejb_ind_app/TimeServiceBean";
        tsr = (TimeServiceRemote) ic.lookup(targetEJBName);
        String timeStr = tsr.getTime();
        System.out.printf("The current time is: %s\n",timeStr);
    }
    
}
